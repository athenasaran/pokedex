package com.athena.features.regions.presentation.state

import com.athena.designsystem.components.cardregions.Regions

data class RegionsUiState(
    val isLoading: Boolean = false,
    val regions: List<Regions> = emptyList(),
    val isError: Boolean = false
) {
    fun initialState() = this.copy(
        isLoading = false,
        regions = emptyList(),
        isError = false
    )
}