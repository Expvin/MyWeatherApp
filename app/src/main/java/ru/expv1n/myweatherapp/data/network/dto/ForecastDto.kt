package ru.expv1n.myweatherapp.data.network.dto

import com.google.gson.annotations.SerializedName

data class ForecastDto(
  @SerializedName("forecastday") val days: List<DayDto>
)