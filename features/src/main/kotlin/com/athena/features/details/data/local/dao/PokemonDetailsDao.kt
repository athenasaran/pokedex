package com.athena.features.details.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.athena.features.details.data.local.model.AbilityEntity
import com.athena.features.details.data.local.model.PokemonDetailsCrossRef
import com.athena.features.details.data.local.model.PokemonDetailsEntity
import com.athena.features.details.data.local.model.TypesEntity

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