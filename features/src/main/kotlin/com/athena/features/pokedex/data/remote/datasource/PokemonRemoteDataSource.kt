package com.athena.features.pokedex.data.remote.datasource

import com.athena.features.pokedex.data.remote.api.PokemonApi
import javax.inject.Inject

private const val LIMIT = 20

class PokemonRemoteDataSource @Inject constructor(
    private val pokemonApi: PokemonApi
) {
    suspend fun getPokemons(offset: Int) = pokemonApi.getPokemons(LIMIT, offset)
}