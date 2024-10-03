package com.athena.features.regions.domain.usecase

import com.athena.features.regions.domain.model.Region
import com.athena.features.regions.domain.repository.RegionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RegionUseCase @Inject constructor(
    private val regionRepository: RegionRepository
) {
    fun getRegions(): Flow<List<Region>> {
        return regionRepository.getRegions()
    }
}