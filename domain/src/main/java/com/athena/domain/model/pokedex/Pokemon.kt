package com.athena.domain.model.pokedex

data class Pokemon(
    val name: String,
    val imageUrl: String,
    val id: String,
    val isFavorite: Boolean
)