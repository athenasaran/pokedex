package com.athena.features.pokedex.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.athena.features.pokedex.data.local.dao.PokemonDao
import com.athena.features.pokedex.data.local.model.PokemonEntity

@Database(entities = [PokemonEntity::class], version = 1)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}