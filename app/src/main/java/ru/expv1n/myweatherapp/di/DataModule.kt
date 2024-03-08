package ru.expv1n.myweatherapp.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.expv1n.myweatherapp.data.local.db.FavouriteCitiesDao
import ru.expv1n.myweatherapp.data.local.db.FavouriteDatabase
import ru.expv1n.myweatherapp.data.network.api.ApiFactory
import ru.expv1n.myweatherapp.data.network.api.ApiService
import ru.expv1n.myweatherapp.data.repository.FavouriteRepositoryImpl
import ru.expv1n.myweatherapp.data.repository.SearchRepositoryImpl
import ru.expv1n.myweatherapp.data.repository.WeatherRepositoryImpl
import ru.expv1n.myweatherapp.domain.repository.FavouriteRepository
import ru.expv1n.myweatherapp.domain.repository.SearchRepository
import ru.expv1n.myweatherapp.domain.repository.WeatherRepository

@Module
interface DataModule {

  @[ApplicationScope Binds]
  fun bindFavouriteRepository(impl: FavouriteRepositoryImpl): FavouriteRepository

  @[ApplicationScope Binds]
  fun bindSearchRepository(impl: SearchRepositoryImpl): SearchRepository

  @[ApplicationScope Binds]
  fun bindWeatherRepository(impl: WeatherRepositoryImpl): WeatherRepository

  companion object {

    @[ApplicationScope Provides]
    fun provideApiService(): ApiService = ApiFactory.apiService

    @[ApplicationScope Provides]
    fun provideDatabase(context: Context): FavouriteDatabase {
      return FavouriteDatabase.getInstance(context)
    }

    @[ApplicationScope Provides]
    fun provideDao(favouriteDatabase: FavouriteDatabase): FavouriteCitiesDao {
      return favouriteDatabase.favoriteCitiesDao()
    }
  }
}