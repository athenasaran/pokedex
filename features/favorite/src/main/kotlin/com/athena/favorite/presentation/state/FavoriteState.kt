package com.athena.favorite.presentation.state

import com.athena.domain.model.favorite.Favorite
import com.athena.features.ScreenState

data class FavoriteState(
    val favorites: List<Favorite> = emptyList(),
    val isLoading: Boolean = false,
    val isEmpty: Boolean = false
) : ScreenState
