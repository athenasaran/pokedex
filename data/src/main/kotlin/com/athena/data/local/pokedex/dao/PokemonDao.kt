package com.athena.data.local.pokedex.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.athena.data.local.pokedex.model.PokemonEntity

@Dao
interface PokemonDao {
    @Query("SELECT * FROM PokemonEntity WHERE page <= :page")
    suspend fun getAllPokemons(page: Int): List<PokemonEntity>

    @Query("SELECT * FROM PokemonEntity WHERE page = :page")
    suspend fun getPokemons(page: Int): List<PokemonEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pokemons: List<PokemonEntity>)
}