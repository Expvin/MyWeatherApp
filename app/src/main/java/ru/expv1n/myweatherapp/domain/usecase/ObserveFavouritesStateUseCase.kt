package ru.expv1n.myweatherapp.domain.usecase

import ru.expv1n.myweatherapp.domain.repository.FavouriteRepository
import javax.inject.Inject

class ObserveFavouritesStateUseCase @Inject constructor(val repository: FavouriteRepository) {

  operator fun invoke(cityId: Int) = repository.observeIsFavourite(cityId)

}