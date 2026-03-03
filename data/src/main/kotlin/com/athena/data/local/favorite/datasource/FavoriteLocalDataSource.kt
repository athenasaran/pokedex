package com.athena.data.local.favorite.datasource

import com.athena.data.local.details.model.FavoritePokemon
import com.athena.data.local.favorite.dao.FavoriteDAO
import com.athena.data.local.favorite.model.FavoritesEntity
import com.athena.domain.model.favorite.Favorite
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
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

    fun getAllFavorites(): Flow<List<Favorite>> {
        return favoriteDAO.getAllPokemonDetailsWithFavorites().map {
            it.toDomain()
        }
    }

    private fun List<FavoritePokemon>.toDomain() = this.map {
        Favorite(
            it.name,
            it.imageUrl,
            it.number
        )
    }
}