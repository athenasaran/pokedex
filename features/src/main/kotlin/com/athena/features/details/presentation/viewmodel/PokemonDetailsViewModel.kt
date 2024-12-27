package com.athena.features.details.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.athena.features.PokeViewModel
import com.athena.features.details.domain.usecase.PokemonDetailsUseCase
import com.athena.features.details.presentation.intent.PokemonDetailsIntent
import com.athena.features.details.presentation.state.PokemonDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val pokemonDetailsUseCase: PokemonDetailsUseCase
) : PokeViewModel<PokemonDetailsState>(PokemonDetailsState()) {

    fun handleIntent(intent: PokemonDetailsIntent) = viewModelScope.launch {
        when (intent) {
            is PokemonDetailsIntent.OnInitScreen -> getPokemonDetails(intent.pokemonName)
            is PokemonDetailsIntent.Retry -> getPokemonDetails(intent.pokemonName)
        }
    }

    private suspend fun getPokemonDetails(name: String) {
        pokemonDetailsUseCase.getPokemonDetails(name).flowOn(Dispatchers.IO).onStart {
            setState { it.copy(isLoading = true) }
        }.onCompletion {
            setState { it.copy(isLoading = false) }
        }.catch {
            setState { it.copy(error = true) }
        }.collect { pokemonDetails ->
            setState { it.copy(pokemonDetails = pokemonDetails) }
        }
    }

}