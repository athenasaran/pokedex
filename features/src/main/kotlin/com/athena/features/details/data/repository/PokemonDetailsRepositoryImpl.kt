package com.athena.features.details.data.repository

import com.athena.features.details.data.remote.datasource.PokemonDetailsDataSource
import com.athena.features.details.domain.model.PokemonDetails
import com.athena.features.details.domain.repository.PokemonDetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokemonDetailsRepositoryImpl @Inject constructor(
    private val pokemonDetailsDataSource: PokemonDetailsDataSource
) : PokemonDetailsRepository {

    override fun getPokemonDetails(name: String): Flow<PokemonDetails> {
        return flow {
            emit(pokemonDetailsDataSource.getPokemonDetails(name))
        }
    }
}