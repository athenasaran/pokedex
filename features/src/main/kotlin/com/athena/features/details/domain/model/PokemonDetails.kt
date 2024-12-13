package com.athena.features.details.domain.model

data class PokemonDetails(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val experience: Int,
    val type: List<Type>,
    val urlImage: String
)

data class Type(
    val name: String
)
