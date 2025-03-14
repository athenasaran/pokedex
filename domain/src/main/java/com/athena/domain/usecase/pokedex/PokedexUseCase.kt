package com.athena.domain.usecase.pokedex

import com.athena.domain.model.pokedex.Pokemon
import com.athena.domain.repository.pokedex.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokedexUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    fun getPokemons(page: Int): Flow<List<Pokemon>> {
        return pokemonRepository.getPokemons(page)
    }
}