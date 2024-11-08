package com.athena.features.pokedex.data.repository

import com.athena.features.pokedex.data.local.datasource.PokemonLocalDataSource
import com.athena.features.pokedex.data.remote.datasource.PokemonRemoteDataSource
import com.athena.features.pokedex.domain.model.Pokemon
import com.athena.features.pokedex.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val pokemonRemoteDataSource: PokemonRemoteDataSource,
    private val pokemonLocalDataSource: PokemonLocalDataSource
) : PokemonRepository {
    override suspend fun getPokemons(page: Int): Flow<List<Pokemon>> {
        return flow {
            val localPageList = pokemonLocalDataSource.getPokemons(page)
            if (localPageList.isEmpty()) {
                val remoteList = pokemonRemoteDataSource.getPokemons(page)
                pokemonLocalDataSource.insertAll(remoteList, page)
            }
            emit(pokemonLocalDataSource.getAllPokemons(page))
        }
    }
}