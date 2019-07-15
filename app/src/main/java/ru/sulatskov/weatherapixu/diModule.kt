package ru.sulatskov.weatherapixu

import android.content.Context

import org.koin.dsl.module
import ru.sulatskov.weatherapixu.main.MainContractInterface
import ru.sulatskov.weatherapixu.main.MainPresenter
import ru.sulatskov.weatherapixu.model.network.services.WeatherService

fun mainModule(context: Context) = module {

    single { WeatherService() }

    factory<MainContractInterface.Presenter> { MainPresenter(get()) }
}

