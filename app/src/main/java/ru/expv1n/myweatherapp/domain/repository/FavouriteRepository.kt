package ru.expv1n.myweatherapp.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.expv1n.myweatherapp.domain.entity.City

interface FavouriteRepository {

  val favouriteCity: Flow<City>

  fun observeIsFavourite(cityId: Int): Flow<Boolean>

  suspend fun addToFavourite(city: City)

  suspend fun removeFromFavourite(cityId: Int)

}