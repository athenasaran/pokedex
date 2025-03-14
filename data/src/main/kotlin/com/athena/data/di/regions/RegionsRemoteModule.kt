package com.athena.data.di.regions

import com.athena.data.remote.regions.api.RegionsApi
import com.athena.data.remote.regions.datasource.RegionsDataSource
import com.athena.data.repository.regions.RegionRepositoryImpl
import com.athena.domain.repository.regions.RegionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RegionsRemoteModule {
    @Singleton
    @Provides
    fun provideRegionsApi(retrofit: Retrofit): RegionsApi = retrofit.create(RegionsApi::class.java)

    @Singleton
    @Provides
    fun provideRegionsRepository(
        regionsDataSource: RegionsDataSource
    ): RegionRepository = RegionRepositoryImpl(regionsDataSource)
}