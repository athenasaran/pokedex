package com.athena.features.pokedex.data.remote.datasource

import com.athena.features.pokedex.data.remote.api.PokemonApi
import com.athena.features.pokedex.data.remote.model.PokemonListResponse
import com.athena.features.pokedex.domain.model.Pokemon
import javax.inject.Inject

private const val LIMIT = 20

class PokemonRemoteDataSource @Inject constructor(
    private val pokemonApi: PokemonApi
) {
    suspend fun getPokemons(offset: Int) = pokemonApi.getPokemons(LIMIT, offset).toPokemonList()

    private fun PokemonListResponse.toPokemonList() = results.map {
        Pokemon(it.name, getImageUrl(it.url))
    }

    private fun getImageUrl(url: String): String {
        val index = url.split("/".toRegex()).dropLast(1).last()
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/" +
                "pokemon/other/official-artwork/$index.png"
    }
}