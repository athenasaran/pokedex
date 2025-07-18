package com.athena.domain.model.details

data class PokemonDetails(
    val id: Int,
    val name: String,
    val height: String,
    val weight: String,
    val experience: String,
    val type: List<Type>,
    val urlImage: String,
    val ability: String,
    val isFavorite: Boolean
)

data class Type(
    val name: String
)
