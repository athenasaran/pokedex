package com.athena.domain.repository.regions

import com.athena.domain.model.regions.Region
import kotlinx.coroutines.flow.Flow

interface RegionRepository {
    fun getRegions(): Flow<List<Region>>
}