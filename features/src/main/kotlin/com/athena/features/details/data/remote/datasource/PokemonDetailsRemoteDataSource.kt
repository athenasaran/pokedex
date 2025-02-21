package com.athena.features.details.data.remote.datasource

import com.athena.features.details.data.model.PokemonInfo
import com.athena.features.details.data.remote.api.PokemonDetailsApi
import com.athena.features.details.domain.model.PokemonDetails
import com.athena.features.details.domain.model.Type
import com.athena.features.utils.upperFirstLetter
import javax.inject.Inject

class PokemonDetailsRemoteDataSource @Inject constructor(
    private val pokemonDetailsApi: PokemonDetailsApi
) {
    suspend fun getPokemonDetails(name: String) = pokemonDetailsApi.getDetailsPokemon(name).toPokemonDetail()

    private fun PokemonInfo.toPokemonDetail() = PokemonDetails(
        id = id,
        name = upperFirstLetter(name),
        height = height.toString(),
        weight = weight.toString(),
        experience = experience.toString(),
        urlImage = sprites.other.officialArtwork.imageArtWork,
        type = types.map { Type(it.type.name) },
        ability = upperFirstLetter(abilities.first().ability.abilityName)
    )
}