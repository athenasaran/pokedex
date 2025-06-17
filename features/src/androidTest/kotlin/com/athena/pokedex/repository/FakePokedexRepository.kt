package com.athena.pokedex.repository

import com.athena.domain.model.pokedex.Pokemon
import com.athena.domain.repository.pokedex.PokedexRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class FakePokedexRepository @Inject constructor() : PokedexRepository {
    override fun getPokemons(page: Int): Flow<List<Pokemon>> {
        return flowOf(listOf())
    }
}