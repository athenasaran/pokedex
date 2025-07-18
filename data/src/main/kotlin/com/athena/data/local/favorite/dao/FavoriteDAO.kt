package com.athena.data.local.favorite.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.athena.data.local.favorite.model.FavoritesEntity

@Dao
interface FavoriteDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favoritesEntity: FavoritesEntity)

    @Query("DELETE FROM favorites WHERE pokemonName = :pokemonName")
    suspend fun deleteFavorite(pokemonName: String)

    @Query("SELECT count(1) FROM favorites WHERE pokemonName = :pokemonName")
    suspend fun isFavorite(pokemonName: String): Int

}