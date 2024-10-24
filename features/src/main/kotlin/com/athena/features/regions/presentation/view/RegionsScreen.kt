package com.athena.features.regions.presentation.view

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
import com.athena.features.regions.presentation.state.RegionsUiState
import com.athena.features.regions.presentation.viewmodel.RegionsViewModel

@Composable
fun RegionsScreen(state: RegionsUiState, modifier: Modifier = Modifier) {
    when {
        state.isLoading -> {
            CircularLoading()
        }

        state.isError -> {
            Text(text = "Error", modifier = modifier.padding(16.dp))
        }

        else -> {
            LazyColumn {
                items(state.regions) { region ->
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
    }
}

@Composable
fun RegionsRoute(viewModel: RegionsViewModel) {
    val state = viewModel.uiState.collectAsState()
    RegionsScreen(state.value)
}