package com.athena.data.di.regions

import com.athena.data.remote.regions.api.RegionsApi
import com.athena.data.repository.regions.RegionRepositoryImpl
import com.athena.domain.repository.regions.RegionRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@InstallIn(ViewModelComponent::class)
@Module
interface RegionsModule {

    companion object {
        @Provides
        fun provideRegionsApi(retrofit: Retrofit): RegionsApi = retrofit.create(RegionsApi::class.java)
    }

    @Binds
    fun provideRegionsRepository(
        regionRepositoryImpl: RegionRepositoryImpl
    ): RegionRepository
}