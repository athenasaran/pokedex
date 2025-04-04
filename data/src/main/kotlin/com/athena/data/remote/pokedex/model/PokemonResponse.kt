package com.athena.data.remote.pokedex.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonResponse(
    @SerialName("name") val name: String,
    @SerialName("url") val url: String
)

@Serializable
data class PokemonListResponse(
    @SerialName("results") val results: List<PokemonResponse>
)