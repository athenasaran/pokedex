package com.athena.domain.repository.favorite

import com.athena.domain.model.favorite.Favorite
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {
    suspend fun insertFavorite(pokemonName: String)

    suspend fun deleteFavorite(pokemonName: String)

    fun getAllFavorites(): Flow<List<Favorite>>
}