package com.athena.data.local.pokedex.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.athena.data.local.pokedex.model.PokemonEntity
import com.athena.data.local.pokedex.model.PokemonHomeDTO

@Dao
interface PokemonDao {
    @Query(
        "SELECT id, name, imageUrl, favorites.pokemonName is not null as isFavorite " +
                "FROM PokemonEntity left join favorites on PokemonEntity.name = favorites.pokemonName  " +
                "WHERE page <= :page"
    )
    suspend fun getAllPokemons(page: Int): List<PokemonHomeDTO>

    @Query("SELECT count(1) FROM PokemonEntity WHERE page = :page")
    suspend fun getPokemons(page: Int): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pokemons: List<PokemonEntity>)
}