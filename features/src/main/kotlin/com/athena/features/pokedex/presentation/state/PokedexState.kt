package com.athena.features.pokedex.presentation.state

import com.athena.features.ScreenState
import com.athena.features.pokedex.domain.model.Pokemon

data class PokedexState(
    val pokemonList: List<Pokemon> = emptyList(),
    val isLoading: Boolean = false,
    val error: Boolean = false
) : ScreenState