package ru.expv1n.myweatherapp.domain.repository

import ru.expv1n.myweatherapp.domain.entity.Forecast
import ru.expv1n.myweatherapp.domain.entity.Weather

interface WeatherRepository {

  suspend fun getWeather(cityId: Int): Weather

  suspend fun getForecast(cityId: Int): Forecast

}