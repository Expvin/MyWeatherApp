package ru.expv1n.myweatherapp.domain.usecase

import ru.expv1n.myweatherapp.domain.entity.City
import ru.expv1n.myweatherapp.domain.repository.FavouriteRepository
import javax.inject.Inject

class ChangeFavouriteStateUseCase @Inject constructor(val repository: FavouriteRepository) {

  suspend fun addToFavourite(city: City) = repository.addToFavourite(city)

  suspend fun removeFromFavourite(cityId: Int) = repository.removeFromFavourite(cityId)

}