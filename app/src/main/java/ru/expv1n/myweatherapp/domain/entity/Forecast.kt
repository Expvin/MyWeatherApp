package ru.expv1n.myweatherapp.domain.entity

data class Forecast(
  val currentWeather: Weather,
  val upcoming: List<Weather>
)
