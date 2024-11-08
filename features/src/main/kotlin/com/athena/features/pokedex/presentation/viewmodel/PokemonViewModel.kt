package com.athena.features.pokedex.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.athena.features.pokedex.domain.repository.PokemonRepository
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
    private val pokemonRepository: PokemonRepository
) : ViewModel() {

    private var currentPage = 0

    private fun getPokemons(page: Int) = viewModelScope.launch {
        pokemonRepository.getPokemons(page).flowOn(Dispatchers.IO).onStart {

        }.onCompletion {

        }.catch {
            Log.d("PokemonViewModel error", it.toString())
        }.collect {
            Log.d("PokemonViewModel", it.toString())
        }
    }

    fun onStart() {
        getPokemons(currentPage)
    }
}