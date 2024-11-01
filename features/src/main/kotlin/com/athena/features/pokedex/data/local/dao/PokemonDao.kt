package com.athena.features.pokedex.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.athena.features.pokedex.data.local.model.PokemonEntity

@Dao
interface PokemonDao {
    @Query("SELECT * FROM PokemonEntity WHERE page <= :page")
    suspend fun getAllPokemons(page: Int): List<PokemonEntity>

    @Query("SELECT * FROM PokemonEntity WHERE page = :page")
    suspend fun getPokemons(page: Int): List<PokemonEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pokemons: List<PokemonEntity>)
}