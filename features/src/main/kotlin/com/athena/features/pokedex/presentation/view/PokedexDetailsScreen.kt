@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.athena.features.pokedex.presentation.view

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.athena.features.details.presentation.intent.PokemonDetailsIntent
import com.athena.features.details.presentation.state.PokemonDetailsState
import com.athena.features.details.presentation.viewmodel.PokemonDetailsViewModel

@Composable
private fun SharedTransitionScope.PokedexDetails(
    modifier: Modifier = Modifier,
    onIntent: (PokemonDetailsIntent) -> Unit,
    pokemonName: String,
    animatedVisibilityScope: AnimatedVisibilityScope,
    onClick: () -> Unit,
    state: PokemonDetailsState
) {
    LaunchedEffect(Unit) {
        onIntent(PokemonDetailsIntent.OnInitScreen(pokemonName))
    }

    state.pokemonDetails?.let { pokemonDetails ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .sharedElement(
                    state = rememberSharedContentState(key = pokemonDetails.name),
                    animatedVisibilityScope = animatedVisibilityScope,
                    boundsTransform = { _, _ -> tween(1000, easing = FastOutLinearInEasing) }
                )
                .clickable {
                    onClick()
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(62.dp),
                model = pokemonDetails.urlImage,
                contentDescription = null
            )
            Text(text = pokemonDetails.name)
            Text(text = pokemonDetails.weight.toString())
            Text(text = pokemonDetails.height.toString())
            Text(text = pokemonDetails.experience.toString())
            pokemonDetails.type.forEach { type ->
                Text(text = type.name)
            }
        }
    }
}

@Composable
fun SharedTransitionScope.PokedexDetailsScreen(
    viewModel: PokemonDetailsViewModel,
    animatedVisibilityScope: AnimatedVisibilityScope,
    pokemonId: String,
    onClick: () -> Unit
) {
    val state by viewModel.screenState.collectAsState()

    PokedexDetails(
        state = state,
        onIntent = viewModel::handleIntent,
        animatedVisibilityScope = animatedVisibilityScope,
        onClick = onClick,
        pokemonName = pokemonId
    )
}