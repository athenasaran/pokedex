package com.athena.features.details.presentation.state

import com.athena.domain.model.details.PokemonDetails
import com.athena.features.ScreenState

data class PokemonDetailsState(
    val pokemonDetails: PokemonDetails? = null,
    val isLoading: Boolean = false,
    val error: Boolean = false
) : ScreenState
