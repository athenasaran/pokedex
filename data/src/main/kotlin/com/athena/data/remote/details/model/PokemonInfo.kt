package com.athena.data.remote.details.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonInfo(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("height") val height: Int,
    @SerialName("weight") val weight: Int,
    @SerialName("base_experience") val experience: Int,
    @SerialName("types") val types: List<TypeResponse>,
    @SerialName("sprites") val sprites: Sprites,
    @SerialName("abilities") val abilities: List<Abilities>
)

@Serializable
data class TypeResponse(
    @SerialName("slot") val slot: Int,
    @SerialName("type") val type: Type,
)

@Serializable
data class Type(
    @SerialName("name") val name: String,
)

@Serializable
data class Sprites(
    @SerialName("other") val other: ArtWork,
)

@Serializable
data class ArtWork(
    @SerialName("official-artwork") val officialArtwork: OfficialArtwork
)

@Serializable
data class OfficialArtwork(
    @SerialName("front_default") val imageArtWork: String
)

@Serializable
data class Abilities(
    @SerialName("ability") val ability: Ability,
)

@Serializable
data class Ability(
    @SerialName("name") val abilityName: String,
)