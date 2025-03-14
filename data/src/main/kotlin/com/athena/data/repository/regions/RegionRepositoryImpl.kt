package com.athena.data.repository.regions

import com.athena.data.remote.regions.datasource.RegionsDataSource
import com.athena.domain.model.regions.Region
import com.athena.domain.repository.regions.RegionRepository
import com.athena.utils.toRomanNumeral
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