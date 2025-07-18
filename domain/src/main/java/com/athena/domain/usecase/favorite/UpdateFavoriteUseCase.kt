package com.athena.domain.usecase.favorite

import com.athena.domain.repository.favorite.FavoriteRepository
import javax.inject.Inject

class UpdateFavoriteUseCase @Inject constructor(
    private val favoriteRepository: FavoriteRepository
) {
    suspend operator fun invoke(pokemonName: String, isFavorite: Boolean) {
        if (isFavorite) {
            favoriteRepository.insertFavorite(pokemonName)
        } else {
            favoriteRepository.deleteFavorite(pokemonName)
        }
    }
}