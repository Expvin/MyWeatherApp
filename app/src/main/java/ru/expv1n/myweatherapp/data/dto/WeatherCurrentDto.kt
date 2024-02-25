package ru.expv1n.myweatherapp.data.dto

import com.google.gson.annotations.SerializedName

data class WeatherCurrentDto(
  @SerializedName("current") val current: WeatherDto
)
