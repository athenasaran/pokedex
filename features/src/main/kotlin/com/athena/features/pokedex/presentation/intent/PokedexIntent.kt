package com.athena.features.pokedex.presentation.intent

sealed interface PokedexIntent {
    data object OnInitScreen : PokedexIntent
    data object LoadMorePokemons : PokedexIntent
    data object Retry : PokedexIntent
    data class OnPokemonClicked(val pokemonName: String) : PokedexIntent
}