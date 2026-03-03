package com.athena.regions.presentation.view

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.athena.designsystem.components.cardregions.CardRegions
import com.athena.designsystem.components.loading.CircularLoading
import com.athena.regions.presentation.model.RegionUI
import com.athena.regions.presentation.state.RegionsUiState
import com.athena.regions.presentation.viewmodel.RegionsViewModel

@Composable
private fun RegionsScreen(state: RegionsUiState, modifier: Modifier = Modifier) {
    when {
        state.isLoading -> {
            CircularLoading()
        }

        state.isError -> {
            Text(text = "Error", modifier = modifier.padding(16.dp))
        }

        else -> {
            RegionsContent(state.regions)
        }
    }
}

@Composable
private fun RegionsContent(
    regions: List<RegionUI>
) {
    LazyColumn {
        items(regions) { region ->
            CardRegions(
                modifier = Modifier.padding(16.dp),
                generationRomanNumber = region.generationRomanNumeral,
                backgroundImage = region.backgroundImage,
                pokemonImages = region.pokemonImages,
                nameRegion = region.nameRegion
            )
        }
    }
}

@Composable
fun RegionsRoute(viewModel: RegionsViewModel) {
    val state = viewModel.uiState.collectAsState()
    RegionsScreen(state.value)
}