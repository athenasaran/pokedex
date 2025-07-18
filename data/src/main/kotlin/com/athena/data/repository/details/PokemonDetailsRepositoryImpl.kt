package com.athena.data.repository.details

import com.athena.data.local.details.datasource.PokemonDetailsLocalDataSource
import com.athena.data.local.favorite.datasource.FavoriteLocalDataSource
import com.athena.data.remote.details.datasource.PokemonDetailsRemoteDataSource
import com.athena.domain.model.details.PokemonDetails
import com.athena.domain.repository.details.PokemonDetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokemonDetailsRepositoryImpl @Inject constructor(
    private val pokemonDetailsRemoteDataSource: PokemonDetailsRemoteDataSource,
    private val pokemonDetailsLocalDataSource: PokemonDetailsLocalDataSource,
    private val favoriteLocalDataSource: FavoriteLocalDataSource
) : PokemonDetailsRepository {

    override fun getPokemonDetails(name: String): Flow<PokemonDetails> {
        return flow {
            val isFavorite = favoriteLocalDataSource.isFavorite(name)
            val localPokemonDetails =
                pokemonDetailsLocalDataSource.getPokemonDetails(name, isFavorite)
            if (localPokemonDetails == null) {
                val remotePokemonDetails =
                    pokemonDetailsRemoteDataSource.getPokemonDetails(name, isFavorite)
                pokemonDetailsLocalDataSource.insertPokemonDetails(remotePokemonDetails)
                emit(remotePokemonDetails)
            } else {
                emit(localPokemonDetails)
            }
        }
    }
}