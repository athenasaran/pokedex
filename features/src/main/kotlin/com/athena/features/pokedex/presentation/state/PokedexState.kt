package com.athena.features.pokedex.presentation.state

import com.athena.domain.model.pokedex.Pokemon
import com.athena.features.ScreenState

data class PokedexState(
    val pokemonList: List<Pokemon> = emptyList(),
    val isLoading: Boolean = false,
    val error: Boolean = false
) : ScreenState