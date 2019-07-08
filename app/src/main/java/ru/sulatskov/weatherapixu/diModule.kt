package ru.sulatskov.weatherapixu

import android.content.Context
import android.os.Build.VERSION_CODES.P
import android.util.Log
import org.koin.dsl.module
import ru.sulatskov.weatherapixu.main.MainContractInterface
import ru.sulatskov.weatherapixu.main.MainPresenter
import ru.sulatskov.weatherapixu.model.local.CityListSharedPreferences
import ru.sulatskov.weatherapixu.model.network.services.WeatherService

fun mainModule(context: Context) = module {

    single { CityListSharedPreferences(context) }
    single { WeatherService() }

    factory<MainContractInterface.Presenter> { MainPresenter(get(), get()) }
}

