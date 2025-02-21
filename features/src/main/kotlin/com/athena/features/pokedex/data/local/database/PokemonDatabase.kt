package com.athena.features.pokedex.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.athena.features.details.data.local.dao.PokemonDetailsDao
import com.athena.features.details.data.local.model.AbilityEntity
import com.athena.features.details.data.local.model.PokemonDetailsEntity
import com.athena.features.details.data.local.model.TypesEntity
import com.athena.features.pokedex.data.local.dao.PokemonDao
import com.athena.features.pokedex.data.local.model.PokemonEntity

@Database(
    entities = [PokemonEntity::class, PokemonDetailsEntity::class, AbilityEntity::class, TypesEntity::class],
    version = 3
)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
    abstract fun pokemonDetailsDao(): PokemonDetailsDao
}