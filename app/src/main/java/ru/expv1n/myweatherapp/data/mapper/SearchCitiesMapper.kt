package ru.expv1n.myweatherapp.data.mapper

import ru.expv1n.myweatherapp.data.network.dto.CityDto
import ru.expv1n.myweatherapp.domain.entity.City

fun CityDto.toEntity() = City(id, name, country)

fun List<CityDto>.toEntities(): List<City> = map { it.toEntity() }