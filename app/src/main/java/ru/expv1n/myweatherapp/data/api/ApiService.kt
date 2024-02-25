package ru.expv1n.myweatherapp.data.api

import retrofit2.http.GET
import retrofit2.http.Query
import ru.expv1n.myweatherapp.data.dto.CityDto
import ru.expv1n.myweatherapp.data.dto.WeatherCurrentDto
import ru.expv1n.myweatherapp.data.dto.WeatherForecastDto

interface ApiService {

  @GET("current.json")
  suspend fun loadCurrentWeather(
    @Query("q") query: String
  ): WeatherCurrentDto

  @GET("forecast.json")
  suspend fun loadForecastWeather(
    @Query("q") query: String,
    @Query("days") days: Int = 4
  ): WeatherForecastDto

  @GET("search.json")
  suspend fun searchCity(
    @Query("q") q: String
  ): List<CityDto>
}