package com.athena.features.pokedex.presentation.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.athena.features.pokedex.presentation.viewmodel.PokemonViewModel

@Composable
fun PokedexScreen(modifier: Modifier = Modifier) {

}

@Composable
fun PokedexRoute(viewModel: PokemonViewModel) {
    LaunchedEffect(Unit) {
        viewModel.onStart()
    }
    PokedexScreen()
}