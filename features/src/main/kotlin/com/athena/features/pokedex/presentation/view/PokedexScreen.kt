@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.athena.features.pokedex.presentation.view

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.athena.designsystem.components.cardpokedex.CardPokedex
import com.athena.domain.model.pokedex.Pokemon
import com.athena.features.pokedex.presentation.intent.PokedexIntent
import com.athena.features.pokedex.presentation.state.PokedexState
import com.athena.features.pokedex.presentation.viewmodel.PokemonViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.PokedexScreen(
    modifier: Modifier = Modifier,
    onIntent: (PokedexIntent) -> Unit,
    state: PokedexState,
    animatedVisibilityScope: AnimatedVisibilityScope,
    onItemClicked: (String) -> Unit
) {
    val listState = rememberLazyListState()

    val showButton by remember {
        derivedStateOf { listState.firstVisibleItemIndex > 2 }
    }

    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = Unit) {
        onIntent(PokedexIntent.OnInitScreen)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        EndlessLazyColumn(
            listState = listState,
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
                        pokemonNumber = pokemon.id,
                        pokemonName = pokemon.name,
                        isFavorite = pokemon.isFavorite,
                        onClickFavorite = { isFavorite ->
                            onIntent(
                                PokedexIntent.OnFavoriteClick(
                                    pokemonName = pokemon.name,
                                    isFavorite = isFavorite
                                )
                            )
                        }
                    ) {
                        onItemClicked(pokemon.name)
                    }
                }
            },
            loadMore = {
                onIntent(PokedexIntent.LoadMorePokemons)
            }
        )

        if (showButton) {
            FloatingActionButton(
                shape = CircleShape,
                modifier = Modifier
                    .size(75.dp)
                    .align(Alignment.BottomEnd)
                    .padding(16.dp),
                onClick = {
                    coroutineScope.launch {
                        listState.animateScrollToItem(0)
                    }
                }
            ) {
                Icon(Icons.Default.KeyboardArrowUp, contentDescription = null)
            }
        }
    }
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