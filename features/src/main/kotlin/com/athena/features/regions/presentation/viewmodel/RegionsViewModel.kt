package com.athena.features.regions.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.athena.designsystem.R
import com.athena.designsystem.components.cardregions.Regions
import com.athena.features.regions.domain.usecase.RegionUseCase
import com.athena.features.regions.presentation.state.RegionsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegionsViewModel @Inject constructor(
    private val regionUseCase: RegionUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(RegionsUiState().initialState())
    val uiState: StateFlow<RegionsUiState> = _uiState

    init {
        viewModelScope.launch {
            regionUseCase.getRegions().flowOn(Dispatchers.IO).catch {
                Log.d("Regions", "error $it")
            }.collect { regions ->
                val listOfRegions = regions.map { region ->
                    Regions(
                        nameRegion = region.name,
                        backgroundImage = R.drawable.region_unova,
                        generationRomanNumeral = region.generationRomanNumber,
                        pokemonImages = listOf(
                            R.drawable.ic_pin_selected,
                            R.drawable.ic_pin_selected,
                            R.drawable.ic_pin_selected
                        )
                    )
                }
                _uiState.update { it.copy(regions = listOfRegions) }
            }
        }

    }
}