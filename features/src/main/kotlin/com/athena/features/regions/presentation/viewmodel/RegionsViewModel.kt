package com.athena.features.regions.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.athena.designsystem.R
import com.athena.designsystem.components.cardregions.Regions
import com.athena.features.regions.presentation.state.RegionsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RegionsViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(RegionsUiState().initialState())
    val uiState: StateFlow<RegionsUiState> = _uiState

    init {
        val regions = listOf(
            Regions(
                "Kanto",
                "4 geração",
                R.drawable.region_unova,
                listOf(
                    R.drawable.ic_pin_selected,
                    R.drawable.ic_pin_selected,
                    R.drawable.ic_pin_selected
                )
            )
        )
        _uiState.update { it.copy(regions = regions) }
    }
}