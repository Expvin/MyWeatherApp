package ru.expv1n.myweatherapp.domain.usecase

import ru.expv1n.myweatherapp.domain.repository.SearchRepository
import javax.inject.Inject

class SearchCityUseCase @Inject constructor(val repository: SearchRepository) {

  suspend operator fun invoke(query: String) = repository.search(query)

}