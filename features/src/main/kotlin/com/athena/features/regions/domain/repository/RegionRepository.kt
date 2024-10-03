package com.athena.features.regions.domain.repository

import com.athena.features.regions.domain.model.Region
import kotlinx.coroutines.flow.Flow

interface RegionRepository {
    fun getRegions(): Flow<List<Region>>
}