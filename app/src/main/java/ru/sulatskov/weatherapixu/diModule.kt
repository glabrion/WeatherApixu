package ru.sulatskov.weatherapixu

import org.koin.dsl.module
import ru.sulatskov.weatherapixu.main.screens.main.MainContractInterface
import ru.sulatskov.weatherapixu.main.screens.main.MainPresenter
import ru.sulatskov.weatherapixu.model.network.services.WeatherService

fun mainModule() = module {

    single { WeatherService() }

    factory<MainContractInterface.Presenter> { MainPresenter(get()) }
}

