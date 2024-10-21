package com.athena.features.regions.presentation.state

import com.athena.features.regions.presentation.model.RegionUI


data class RegionsUiState(
    val isLoading: Boolean = false,
    val regions: List<RegionUI> = emptyList(),
    val isError: Boolean = false
) {
    fun initialState() = this.copy(
        isLoading = false,
        regions = emptyList(),
        isError = false
    )
}