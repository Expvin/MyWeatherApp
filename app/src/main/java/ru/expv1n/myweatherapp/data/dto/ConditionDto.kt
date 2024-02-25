package ru.expv1n.myweatherapp.data.dto

import com.google.gson.annotations.SerializedName

data class ConditionDto(
  @SerializedName("text") val text: String,
  @SerializedName("icon") val icon: String
)
