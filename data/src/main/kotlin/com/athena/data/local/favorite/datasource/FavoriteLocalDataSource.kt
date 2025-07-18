package com.athena.data.local.favorite.datasource

import com.athena.data.local.favorite.dao.FavoriteDAO
import com.athena.data.local.favorite.model.FavoritesEntity
import javax.inject.Inject

class FavoriteLocalDataSource @Inject constructor(
    private val favoriteDAO: FavoriteDAO
) {
    suspend fun insertFavorite(pokemonName: String) {
        val favoritesEntity = FavoritesEntity(pokemonName = pokemonName)
        favoriteDAO.insertFavorite(favoritesEntity)
    }

    suspend fun deleteFavorite(pokemonName: String) {
        favoriteDAO.deleteFavorite(pokemonName)
    }

    suspend fun isFavorite(pokemonName: String): Boolean {
        return favoriteDAO.isFavorite(pokemonName) > 0
    }
}