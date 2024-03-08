package ru.expv1n.myweatherapp.data.mapper

import ru.expv1n.myweatherapp.data.network.dto.WeatherCurrentDto
import ru.expv1n.myweatherapp.data.network.dto.WeatherDto
import ru.expv1n.myweatherapp.data.network.dto.WeatherForecastDto
import ru.expv1n.myweatherapp.domain.entity.Forecast
import ru.expv1n.myweatherapp.domain.entity.Weather
import java.util.Calendar
import java.util.Date

fun WeatherCurrentDto.toEntity(): Weather = current.toEntity()

fun WeatherDto.toEntity(): Weather = Weather(
  tempC = tempC,
  conditionText = conditionDto.text,
  conditionUrl = conditionDto.icon.correctImageUrl(),
  date = date.toCalendar()
)

fun WeatherForecastDto.toEntity(): Forecast = Forecast(
  currentWeather = current.toEntity(),
  upcoming = forecastDto.days.drop(1).map { dayDto ->
    Weather(
      tempC = dayDto.day.tempC,
      conditionText = dayDto.day.conditionDto.text,
      conditionUrl = dayDto.day.conditionDto.icon.correctImageUrl(),
      date = dayDto.date.toCalendar()
    )
  }
)

private fun Long.toCalendar() = Calendar.getInstance().apply {
  time = Date(this@toCalendar * 1000)
}

private fun String.correctImageUrl() = "https:$this".replace(
  oldValue = "64x64",
  newValue = "128x128"
)