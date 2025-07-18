package com.athena.domain.repository.favorite

interface FavoriteRepository {
    suspend fun insertFavorite(pokemonName: String)

    suspend fun deleteFavorite(pokemonName: String)
}