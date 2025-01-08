@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.athena.features.pokedex.presentation.view

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.athena.designsystem.components.cardpokedex.CardPokedex
import com.athena.designsystem.components.pokemon.PokemonType
import com.athena.features.pokedex.domain.model.Pokemon
import com.athena.features.pokedex.presentation.intent.PokedexIntent
import com.athena.features.pokedex.presentation.state.PokedexState
import com.athena.features.pokedex.presentation.viewmodel.PokemonViewModel

@Composable
fun SharedTransitionScope.PokedexScreen(
    modifier: Modifier = Modifier,
    onIntent: (PokedexIntent) -> Unit,
    state: PokedexState,
    animatedVisibilityScope: AnimatedVisibilityScope,
    onItemClicked: (String) -> Unit
) {
    LaunchedEffect(key1 = Unit) {
        onIntent(PokedexIntent.OnInitScreen)
    }

    EndlessLazyColumn(
        modifier = modifier,
        buffer = 3,
        items = state.pokemonList,
        itemKey = { card: Pokemon -> card.name },
        itemContent = { pokemon: Pokemon ->
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .sharedElement(
                        state = rememberSharedContentState(key = pokemon.name),
                        animatedVisibilityScope = animatedVisibilityScope,
                        boundsTransform = { _, _ -> tween(1000) }
                    )
            ) {
                CardPokedex(
                    backgroundImage = pokemon.imageUrl,
                    pokemonType = listOf(PokemonType.WATER, PokemonType.FIRE),
                    pokemonNumber = pokemon.id,
                    pokemonName = pokemon.name,
                    onClickFavorite = {}
                ) {
                    onItemClicked(pokemon.name)
                }
            }
        },
        loadMore = {
            onIntent(PokedexIntent.LoadMorePokemons)
        }
    )
}

@Composable
fun SharedTransitionScope.PokedexRoute(
    viewModel: PokemonViewModel,
    animatedVisibilityScope: AnimatedVisibilityScope,
    onItemClicked: (String) -> Unit
) {
    val state by viewModel.screenState.collectAsState()

    PokedexScreen(
        onIntent = viewModel::handleIntent,
        state = state,
        animatedVisibilityScope = animatedVisibilityScope
    ) {
        onItemClicked(it)
    }
}