package com.athena.domain.usecase.regions

import com.athena.domain.model.regions.Region
import com.athena.domain.repository.regions.RegionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RegionUseCase @Inject constructor(
    private val regionRepository: RegionRepository
) {
    fun getRegions(): Flow<List<Region>> {
        return regionRepository.getRegions()
    }
}