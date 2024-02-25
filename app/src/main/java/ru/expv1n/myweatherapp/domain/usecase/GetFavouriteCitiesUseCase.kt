package ru.expv1n.myweatherapp.domain.usecase

import ru.expv1n.myweatherapp.domain.repository.FavouriteRepository
import javax.inject.Inject

class GetFavouriteCitiesUseCase @Inject constructor(val repository: FavouriteRepository) {
   operator fun invoke() = repository.favouriteCity
}