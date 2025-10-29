package com.athena.data.local.favorite.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.athena.data.local.details.model.FavoritePokemon
import com.athena.data.local.favorite.model.FavoritesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favoritesEntity: FavoritesEntity)

    @Query("DELETE FROM favorites WHERE pokemonName = :pokemonName")
    suspend fun deleteFavorite(pokemonName: String)

    @Query("SELECT count(1) FROM favorites WHERE pokemonName = :pokemonName")
    suspend fun isFavorite(pokemonName: String): Int

    @Query("SELECT * FROM PokemonEntity p INNER JOIN favorites f ON p.name LIKE f.pokemonName")
    fun getAllPokemonDetailsWithFavorites(): Flow<List<FavoritePokemon>>
}