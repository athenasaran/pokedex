package com.athena.features.pokedex.presentation.view

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.athena.features.pokedex.presentation.intent.PokedexIntent
import com.athena.features.pokedex.presentation.state.PokedexState
import com.athena.features.pokedex.presentation.viewmodel.PokemonViewModel
import kotlinx.coroutines.flow.distinctUntilChanged

@Composable
fun PokedexScreen(
    modifier: Modifier = Modifier,
    onIntent: (PokedexIntent) -> Unit,
    state: PokedexState
) {
    val lazyListState = rememberLazyListState()

    LaunchedEffect(key1 = Unit) {
        onIntent(PokedexIntent.OnInitScreen)
    }

    val loadMore = remember {
        derivedStateOf {
            val layoutInfo = lazyListState.layoutInfo
            val totalItemsNumber = layoutInfo.totalItemsCount
            val lastVisibleItemIndex = (layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0) + 1
            lastVisibleItemIndex > (totalItemsNumber - 5)
        }
    }

    LaunchedEffect(loadMore) {
        snapshotFlow { loadMore.value }
            .distinctUntilChanged()
            .collect {
                onIntent(PokedexIntent.LoadMorePokemons)
            }
    }

    LazyColumn {
        items(state.pokemonList) { pokemon ->
            Text(
                text = pokemon.name,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun PokedexRoute(viewModel: PokemonViewModel) {
    val state by viewModel.screenState.collectAsState()

    PokedexScreen(
        onIntent = viewModel::handleIntent,
        state = state
    )
}