package com.athena.favorite.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.athena.domain.usecase.favorite.GetAllFavoriteUseCase
import com.athena.domain.usecase.favorite.UpdateFavoriteUseCase
import com.athena.favorite.presentation.intent.FavoriteIntent
import com.athena.favorite.presentation.state.FavoriteState
import com.athena.features.PokeViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getAllFavoriteUseCase: GetAllFavoriteUseCase,
    private val updateFavoriteUseCase: UpdateFavoriteUseCase
) : PokeViewModel<FavoriteState>(FavoriteState()) {

    fun handleIntent(intent: FavoriteIntent) {
        when (intent) {
            is FavoriteIntent.OnInitScreen -> getAllFavorite()
            is FavoriteIntent.OnItemDeleted -> updateFavorite(intent.name)
        }
    }

    private fun getAllFavorite() = viewModelScope.launch {
        getAllFavoriteUseCase.invoke()
            .onStart {
                setState { it.copy(isLoading = true) }
            }.onCompletion {
                setState { it.copy(isLoading = false) }
            }.collect { favorites ->
                setState {
                    it.copy(
                        favorites = favorites,
                        isEmpty = favorites.isEmpty(),
                        isLoading = false
                    )
                }
            }
    }

    private fun updateFavorite(name: String) = viewModelScope.launch {
        updateFavoriteUseCase.invoke(name, false)
    }
}