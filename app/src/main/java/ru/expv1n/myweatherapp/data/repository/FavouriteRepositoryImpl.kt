package ru.expv1n.myweatherapp.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.expv1n.myweatherapp.data.local.db.FavouriteCitiesDao
import ru.expv1n.myweatherapp.data.mapper.toDbModel
import ru.expv1n.myweatherapp.data.mapper.toEntities
import ru.expv1n.myweatherapp.domain.entity.City
import ru.expv1n.myweatherapp.domain.repository.FavouriteRepository
import javax.inject.Inject

class FavouriteRepositoryImpl @Inject constructor(
  private val favouriteCitiesDao: FavouriteCitiesDao
) : FavouriteRepository {

  override val favouriteCity: Flow<List<City>> = favouriteCitiesDao.getFavouriteCities()
    .map { it.toEntities() }

  override fun observeIsFavourite(cityId: Int): Flow<Boolean> = favouriteCitiesDao.observeFavourite(cityId)

  override suspend fun addToFavourite(city: City) = favouriteCitiesDao.addToFavourite(city.toDbModel())

  override suspend fun removeFromFavourite(cityId: Int) = favouriteCitiesDao.removeCity(cityId)
}