package com.athena.features

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

abstract class PokeViewModel<STATE : ScreenState>(
    initialState: STATE
) : ViewModel() {

    private val state = MutableStateFlow(initialState)
    val screenState: StateFlow<STATE> = state
    fun setState(screenState: (STATE) -> STATE) {
        state.update(screenState)
    }
}

interface ScreenState