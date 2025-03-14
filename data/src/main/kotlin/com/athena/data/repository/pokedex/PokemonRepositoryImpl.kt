package com.athena.data.repository.pokedex

import com.athena.data.local.pokedex.datasource.PokemonLocalDataSource
import com.athena.data.remote.pokedex.datasource.PokemonRemoteDataSource
import com.athena.domain.model.pokedex.Pokemon
import com.athena.domain.repository.pokedex.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val pokemonRemoteDataSource: PokemonRemoteDataSource,
    private val pokemonLocalDataSource: PokemonLocalDataSource
) : PokemonRepository {
    override fun getPokemons(page: Int): Flow<List<Pokemon>> {
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