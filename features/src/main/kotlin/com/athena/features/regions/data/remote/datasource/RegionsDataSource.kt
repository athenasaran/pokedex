package com.athena.features.regions.data.remote.datasource

import com.athena.features.regions.data.remote.model.RegionResponse
import kotlinx.coroutines.flow.Flow

interface RegionsDataSource {
    fun getRegions(): Flow<List<RegionResponse>>
}