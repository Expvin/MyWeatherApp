package ru.expv1n.myweatherapp.domain.repository

import ru.expv1n.myweatherapp.domain.entity.City

interface SearchRepository {

  suspend fun search(query: String): List<City>

}