package ru.expv1n.myweatherapp.domain.usecase

import ru.expv1n.myweatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

class GetForecastUseCase @Inject constructor(val repository: WeatherRepository) {

  suspend operator fun invoke(cityId: Int) = repository.getForecast(cityId)

}