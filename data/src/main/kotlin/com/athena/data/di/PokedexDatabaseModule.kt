package com.athena.data.di

import android.app.Application
import androidx.room.Room
import com.athena.data.local.details.dao.PokemonDetailsDao
import com.athena.data.local.pokedex.dao.PokemonDao
import com.athena.data.local.pokedex.database.PokemonDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class PokedexDatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(
        application: Application
    ): PokemonDatabase {
        return Room
            .databaseBuilder(application, PokemonDatabase::class.java, "Pokedex.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providePokemonDao(appDatabase: PokemonDatabase): PokemonDao {
        return appDatabase.pokemonDao()
    }

    @Provides
    @Singleton
    fun providePokemonDetailsDao(appDatabase: PokemonDatabase): PokemonDetailsDao {
        return appDatabase.pokemonDetailsDao()
    }
}