package com.athena.domain.repository.details

import com.athena.domain.model.details.PokemonDetails
import kotlinx.coroutines.flow.Flow

interface PokemonDetailsRepository {
    fun getPokemonDetails(name: String): Flow<PokemonDetails>
}