package com.athena.domain.usecase.details

import com.athena.domain.model.details.PokemonDetails
import com.athena.domain.repository.details.PokemonDetailsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonDetailsUseCase @Inject constructor(
    private val pokemonDetailsRepository: PokemonDetailsRepository
) {
    fun getPokemonDetails(name: String): Flow<PokemonDetails> {
        return pokemonDetailsRepository.getPokemonDetails(name)
    }
}