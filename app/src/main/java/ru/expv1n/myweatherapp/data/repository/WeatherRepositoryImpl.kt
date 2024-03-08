package ru.expv1n.myweatherapp.data.repository

import ru.expv1n.myweatherapp.data.mapper.toEntity
import ru.expv1n.myweatherapp.data.network.api.ApiService
import ru.expv1n.myweatherapp.domain.entity.Forecast
import ru.expv1n.myweatherapp.domain.entity.Weather
import ru.expv1n.myweatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
  private val apiService: ApiService
) : WeatherRepository {

  override suspend fun getWeather(cityId: Int): Weather = apiService
    .loadCurrentWeather("$PREFIX_CITY_ID$cityId").toEntity()

  override suspend fun getForecast(cityId: Int): Forecast = apiService
    .loadForecastWeather("$PREFIX_CITY_ID$cityId").toEntity()

  private companion object {
    private const val PREFIX_CITY_ID = "id:"
  }

}