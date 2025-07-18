package com.athena.data.di.favorite

import com.athena.data.repository.favorite.FavoriteRepositoryImpl
import com.athena.domain.repository.favorite.FavoriteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class FavoriteModule {

    @Binds
    abstract fun provideFavoriteRepository(favoriteRepositoryImpl: FavoriteRepositoryImpl): FavoriteRepository
}