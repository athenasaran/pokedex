package com.athena.features.details.presentation.intent

sealed interface PokemonDetailsIntent {
    data class OnInitScreen(val pokemonName: String) : PokemonDetailsIntent
    data class OnFavoriteClick(val pokemonName: String, val isFavorite: Boolean) :
        PokemonDetailsIntent
    data class Retry(val pokemonName: String) : PokemonDetailsIntent
}