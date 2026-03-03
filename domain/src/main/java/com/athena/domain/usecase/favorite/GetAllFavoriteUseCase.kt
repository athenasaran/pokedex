package com.athena.domain.usecase.favorite

import com.athena.domain.model.favorite.Favorite
import com.athena.domain.repository.favorite.FavoriteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllFavoriteUseCase @Inject constructor(
    private val favoriteRepository: FavoriteRepository
) {
    operator fun invoke(): Flow<List<Favorite>> {
        return favoriteRepository.getAllFavorites()
    }
}