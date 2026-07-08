package com.athena.data.local.pokedex.model

internal data class PokemonHomeDTO(
    val name: String,
    val imageUrl: String,
    val id: String,
    val isFavorite: Boolean
)
