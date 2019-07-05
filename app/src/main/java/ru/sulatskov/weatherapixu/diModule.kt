package ru.sulatskov.weatherapixu

import android.content.Context
import org.koin.dsl.module
import ru.sulatskov.weatherapixu.main.MainPresenter
import ru.sulatskov.weatherapixu.model.local.CityListSharedPreferences
import ru.sulatskov.weatherapixu.model.network.services.WeatherService

fun mainModule(context: Context) = module {

    single { CityListSharedPreferences(context) }
    single { WeatherService() }

    factory { MainPresenter(get(), get()) }
}

