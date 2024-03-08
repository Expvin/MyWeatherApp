package ru.expv1n.myweatherapp.data.repository

import ru.expv1n.myweatherapp.data.mapper.toEntities
import ru.expv1n.myweatherapp.data.network.api.ApiService
import ru.expv1n.myweatherapp.domain.entity.City
import ru.expv1n.myweatherapp.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
  private val apiService: ApiService
) : SearchRepository {

  override suspend fun search(query: String): List<City> = apiService.searchCity(query).toEntities()

}