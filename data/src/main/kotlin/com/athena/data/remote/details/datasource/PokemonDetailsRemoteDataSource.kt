package com.athena.data.remote.details.datasource

import com.athena.data.remote.details.api.PokemonDetailsApi
import com.athena.data.remote.details.model.PokemonInfo
import com.athena.domain.model.details.PokemonDetails
import com.athena.domain.model.details.Type
import com.athena.utils.upperFirstLetter
import javax.inject.Inject

class PokemonDetailsRemoteDataSource @Inject constructor(
    private val pokemonDetailsApi: PokemonDetailsApi
) {
    suspend fun getPokemonDetails(name: String, isFavorite: Boolean) =
        pokemonDetailsApi.getDetailsPokemon(name.lowercase()).toPokemonDetail(isFavorite)

    private fun PokemonInfo.toPokemonDetail(isFavorite: Boolean) = PokemonDetails(
        id = id,
        name = upperFirstLetter(name),
        height = height.toString(),
        weight = weight.toString(),
        experience = experience.toString(),
        urlImage = sprites.other.officialArtwork.imageArtWork,
        type = types.map { Type(it.type.name) },
        ability = upperFirstLetter(abilities.first().ability.abilityName),
        isFavorite = isFavorite
    )
}