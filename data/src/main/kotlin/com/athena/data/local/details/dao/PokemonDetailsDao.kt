package com.athena.data.local.details.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.athena.data.local.details.model.AbilityEntity
import com.athena.data.local.details.model.PokemonDetailsCrossRef
import com.athena.data.local.details.model.PokemonDetailsEntity
import com.athena.data.local.details.model.TypesEntity

@Dao
interface PokemonDetailsDao {
    @Transaction
    @Query("SELECT * FROM PokemonDetailsEntity WHERE name = :name limit 1")
    suspend fun getPokemonDetails(name: String): PokemonDetailsCrossRef?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonDetails(pokemonDetailsEntity: PokemonDetailsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonTypes(typesEntity: List<TypesEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonAbility(abilityEntity: AbilityEntity)
}