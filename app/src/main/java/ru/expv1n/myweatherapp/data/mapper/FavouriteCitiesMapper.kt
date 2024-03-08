package ru.expv1n.myweatherapp.data.mapper

import ru.expv1n.myweatherapp.data.local.model.CityDbModel
import ru.expv1n.myweatherapp.domain.entity.City

fun CityDbModel.toEntity() = City(id, name, country)

fun City.toDbModel() = CityDbModel(id, name, country)

fun List<CityDbModel>.toEntities(): List<City> = map { it.toEntity() }