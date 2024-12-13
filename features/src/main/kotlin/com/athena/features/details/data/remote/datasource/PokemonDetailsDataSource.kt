package com.athena.features.details.data.remote.datasource

import com.athena.features.details.data.model.PokemonInfo
import com.athena.features.details.data.remote.api.PokemonDetailsApi
import com.athena.features.details.domain.model.PokemonDetails
import com.athena.features.details.domain.model.Type
import javax.inject.Inject

class PokemonDetailsDataSource @Inject constructor(
    private val pokemonDetailsApi: PokemonDetailsApi
) {
    suspend fun getPokemonDetails(name: String) = pokemonDetailsApi.getDetailsPokemon(name).toPokemonDetail()

    private fun PokemonInfo.toPokemonDetail() = PokemonDetails(
        id = id,
        name = name,
        height = height,
        weight = weight,
        experience = experience,
        urlImage = sprites.other.officialArtwork.imageArtWork,
        type = types.map { Type(it.type.name) }
    )
}