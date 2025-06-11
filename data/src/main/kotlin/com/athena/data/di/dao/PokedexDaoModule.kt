package com.athena.data.di.dao

import com.athena.data.local.database.PokemonDatabase
import com.athena.data.local.details.dao.PokemonDetailsDao
import com.athena.data.local.pokedex.dao.PokemonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
class PokedexDaoModule {
    @Provides
    fun providePokemonDao(appDatabase: PokemonDatabase): PokemonDao {
        return appDatabase.pokemonDao()
    }

    @Provides
    fun providePokemonDetailsDao(appDatabase: PokemonDatabase): PokemonDetailsDao {
        return appDatabase.pokemonDetailsDao()
    }
}