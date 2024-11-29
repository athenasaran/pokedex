package com.athena.features.pokedex.presentation.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.athena.features.pokedex.domain.model.Pokemon
import com.athena.features.pokedex.presentation.intent.PokedexIntent
import com.athena.features.pokedex.presentation.state.PokedexState
import com.athena.features.pokedex.presentation.viewmodel.PokemonViewModel

@Composable
fun PokedexScreen(
    modifier: Modifier = Modifier,
    onIntent: (PokedexIntent) -> Unit,
    state: PokedexState
) {
    LaunchedEffect(key1 = Unit) {
        onIntent(PokedexIntent.OnInitScreen)
    }

    EndlessLazyColumn(
        buffer = 3,
        items = state.pokemonList,
        itemKey = { card: Pokemon -> card.name },
        itemContent = { pokemon: Pokemon ->
            Text(
                text = pokemon.name,
                modifier = Modifier.padding(16.dp)
            )
        },
        loadMore = {
            onIntent(PokedexIntent.LoadMorePokemons)
        }
    )
}

@Composable
fun PokedexRoute(viewModel: PokemonViewModel) {
    val state by viewModel.screenState.collectAsState()

    PokedexScreen(
        onIntent = viewModel::handleIntent,
        state = state
    )
}