package com.athena.favorite.presentation.intent

sealed interface FavoriteIntent {
    data object OnInitScreen : FavoriteIntent
    data class OnItemDeleted(val name: String) : FavoriteIntent
}