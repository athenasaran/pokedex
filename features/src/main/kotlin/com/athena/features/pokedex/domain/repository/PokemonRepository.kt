package com.athena.features.pokedex.domain.repository

import com.athena.features.pokedex.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    suspend fun getPokemons(page: Int): Flow<List<Pokemon>>
}