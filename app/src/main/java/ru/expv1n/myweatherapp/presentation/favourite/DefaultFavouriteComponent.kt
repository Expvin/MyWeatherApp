package ru.expv1n.myweatherapp.presentation.favourite

import com.arkivanov.decompose.ComponentContext

class DefaultFavouriteComponent(
  componentContext: ComponentContext
) : FavouriteComponent, ComponentContext by componentContext