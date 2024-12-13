package com.athena.features.details.domain.repository

import com.athena.features.details.domain.model.PokemonDetails
import kotlinx.coroutines.flow.Flow

interface PokemonDetailsRepository {
    fun getPokemonDetails(name: String): Flow<PokemonDetails>
}