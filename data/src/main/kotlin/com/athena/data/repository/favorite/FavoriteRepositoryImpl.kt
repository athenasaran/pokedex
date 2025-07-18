package com.athena.data.repository.favorite

import com.athena.data.local.favorite.datasource.FavoriteLocalDataSource
import com.athena.domain.repository.favorite.FavoriteRepository
import javax.inject.Inject

class FavoriteRepositoryImpl @Inject constructor(
    private val favoriteLocalDataSource: FavoriteLocalDataSource
) : FavoriteRepository {

    override suspend fun insertFavorite(pokemonName: String) {
        favoriteLocalDataSource.insertFavorite(pokemonName)
    }

    override suspend fun deleteFavorite(pokemonName: String) {
        favoriteLocalDataSource.deleteFavorite(pokemonName)
    }
}