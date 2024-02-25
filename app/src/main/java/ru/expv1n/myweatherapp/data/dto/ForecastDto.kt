package ru.expv1n.myweatherapp.data.dto

import com.google.gson.annotations.SerializedName

data class ForecastDto(
  @SerializedName("forecastday") val days: List<DayDto>
)
