package com.athena.features.regions.data.repository

import com.athena.features.regions.data.remote.datasource.RegionsDataSource
import com.athena.features.regions.domain.model.Region
import com.athena.features.regions.domain.repository.RegionRepository
import com.athena.features.utils.toRomanNumeral
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RegionRepositoryImpl @Inject constructor(
    private val regionsDataSource: RegionsDataSource
) : RegionRepository {
    override fun getRegions(): Flow<List<Region>> {
        return regionsDataSource.getRegions().map { regions ->
            regions.map { regionResponse ->
                val id = regionResponse.url.takeLast(2).dropLast(1)
                Region(
                    name = regionResponse.name.replaceFirstChar { it.uppercase() },
                    id = id,
                    generationRomanNumber = id.toInt().toRomanNumeral()
                )
            }
        }
    }
}