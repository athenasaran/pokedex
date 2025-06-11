package com.athena.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.athena.data.local.details.dao.PokemonDetailsDao
import com.athena.data.local.details.model.AbilityEntity
import com.athena.data.local.details.model.PokemonDetailsEntity
import com.athena.data.local.details.model.TypesEntity
import com.athena.data.local.favorite.model.FavoritesEntity
import com.athena.data.local.pokedex.dao.PokemonDao
import com.athena.data.local.pokedex.model.PokemonEntity

@Database(
    entities = [
        PokemonEntity::class,
        PokemonDetailsEntity::class,
        AbilityEntity::class,
        TypesEntity::class,
        FavoritesEntity::class
    ],
    version = 1
)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
    abstract fun pokemonDetailsDao(): PokemonDetailsDao
}