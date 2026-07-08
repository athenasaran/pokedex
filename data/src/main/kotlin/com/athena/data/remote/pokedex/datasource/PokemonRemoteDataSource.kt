package com.athena.data.remote.pokedex.datasource

import com.athena.data.remote.pokedex.api.PokemonApi
import com.athena.data.remote.pokedex.model.PokemonListResponse
import com.athena.domain.model.pokedex.Pokemon
import com.athena.utils.upperFirstLetter
import javax.inject.Inject

private const val LIMIT = 20

internal class PokemonRemoteDataSource @Inject constructor(
    private val pokemonApi: PokemonApi
) {
    suspend fun getPokemons(offset: Int) = pokemonApi.getPokemons(LIMIT, offset * LIMIT).toPokemonList()

    private fun PokemonListResponse.toPokemonList() = results.map {
        Pokemon(
            name = upperFirstLetter(it.name),
            imageUrl = getImageUrl(it.url),
            id = getId(it.url),
            isFavorite = false
        )
    }

    private fun getImageUrl(url: String): String {
        val index = url.split("/".toRegex()).dropLast(1).last()
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/" +
                "pokemon/other/official-artwork/$index.png"
    }

    private fun getId(url: String): String {
        return url.split("/".toRegex()).dropLast(1).last()
    }
}