package com.athena.features.regions.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.athena.features.regions.domain.usecase.RegionUseCase
import com.athena.features.regions.presentation.model.toUI
import com.athena.features.regions.presentation.state.RegionsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
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
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            regionUseCase.getRegions().flowOn(Dispatchers.IO).catch {
                _uiState.update { it.copy(isError = true, isLoading = false) }
            }.map {
                it.toUI()
            }.collect { regions ->
                _uiState.update { it.copy(regions = regions, isLoading = false) }
            }
        }
    }
}