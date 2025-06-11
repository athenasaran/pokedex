package com.athena.domain.repository.pokedex

import com.athena.domain.model.pokedex.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokedexRepository {
    fun getPokemons(page: Int): Flow<List<Pokemon>>
}