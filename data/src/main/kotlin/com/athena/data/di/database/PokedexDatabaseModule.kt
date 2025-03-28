package com.athena.data.di.database

import android.app.Application
import androidx.room.Room
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
}
