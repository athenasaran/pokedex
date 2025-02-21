package com.athena.features.details.data.repository

import com.athena.features.details.data.local.datasource.PokemonDetailsLocalDataSource
import com.athena.features.details.data.remote.datasource.PokemonDetailsRemoteDataSource
import com.athena.features.details.domain.model.PokemonDetails
import com.athena.features.details.domain.repository.PokemonDetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokemonDetailsRepositoryImpl @Inject constructor(
    private val pokemonDetailsRemoteDataSource: PokemonDetailsRemoteDataSource,
    private val pokemonDetailsLocalDataSource: PokemonDetailsLocalDataSource
) : PokemonDetailsRepository {

    override fun getPokemonDetails(name: String): Flow<PokemonDetails> {
        return flow {
            val localPokemonDetails = pokemonDetailsLocalDataSource.getPokemonDetails(name)
            if (localPokemonDetails == null) {
                val remotePokemonDetails = pokemonDetailsRemoteDataSource.getPokemonDetails(name)
                pokemonDetailsLocalDataSource.insertPokemonDetails(remotePokemonDetails)
                emit(remotePokemonDetails)
            } else {
                emit(localPokemonDetails)
            }
        }
    }
}