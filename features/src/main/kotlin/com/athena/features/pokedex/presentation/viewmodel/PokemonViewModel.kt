package com.athena.features.pokedex.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.athena.domain.usecase.pokedex.PokedexUseCase
import com.athena.features.PokeViewModel
import com.athena.features.pokedex.presentation.intent.PokedexIntent
import com.athena.features.pokedex.presentation.state.PokedexState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val pokedexUseCase: PokedexUseCase
) : PokeViewModel<PokedexState>(PokedexState()) {

    private var currentPage = 0

    fun handleIntent(intent: PokedexIntent) = viewModelScope.launch {
        when (intent) {
            is PokedexIntent.OnInitScreen -> getPokemons(currentPage)
            is PokedexIntent.LoadMorePokemons -> getPokemons(++currentPage)
            is PokedexIntent.Retry -> getPokemons(currentPage)
        }
    }

    private suspend fun getPokemons(page: Int) {
        pokedexUseCase.getPokemons(page).flowOn(Dispatchers.IO).onStart {
            setState { it.copy(isLoading = true) }
        }.onCompletion {
            setState { it.copy(isLoading = false) }
        }.catch { e ->
            Log.d("PokemonList", "Error $e")
            setState { it.copy(error = true) }
        }.collect { list ->
            Log.d("PokemonList", "$list")
            setState { it.copy(pokemonList = list) }
        }
    }
}