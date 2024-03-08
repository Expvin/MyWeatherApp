package ru.expv1n.myweatherapp

import android.app.Application
import ru.expv1n.myweatherapp.di.ApplicationComponent
import ru.expv1n.myweatherapp.di.DaggerApplicationComponent

class WeatherApp: Application() {

  lateinit var applicationComponent: ApplicationComponent

  override fun onCreate() {
    super.onCreate()
    applicationComponent = DaggerApplicationComponent.factory().create(this)
  }

}