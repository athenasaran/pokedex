package com.athena.features.details.presentation.state

import com.athena.features.ScreenState
import com.athena.features.details.domain.model.PokemonDetails

data class PokemonDetailsState(
    val pokemonDetails: PokemonDetails? = null,
    val isLoading: Boolean = false,
    val error: Boolean = false
) : ScreenState
