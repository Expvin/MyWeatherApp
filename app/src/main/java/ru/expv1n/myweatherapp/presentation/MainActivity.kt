package ru.expv1n.myweatherapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.expv1n.myweatherapp.data.api.ApiFactory
import ru.expv1n.myweatherapp.presentation.ui.theme.MyWeatherAppTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val apiService = ApiFactory.apiService
    CoroutineScope(Dispatchers.Main).launch {
      val currentWeather = apiService.loadCurrentWeather("Moscow")
      val currentForecast = apiService.loadForecastWeather("Moscow")
      val searchCities = apiService.searchCity("Moscow")
      Log.d("MainActivity", "Current Weather - ${currentWeather} \n" +
        "Current Forecast - ${currentForecast} \n" +
        "Search Cities - ${searchCities}")
    }
    setContent {
      MyWeatherAppTheme {
      }
    }
  }
}
