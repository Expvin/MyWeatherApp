package ru.expv1n.myweatherapp.data.network.dto

import com.google.gson.annotations.SerializedName

data class WeatherCurrentDto(
  @SerializedName("current") val current: WeatherDto
)