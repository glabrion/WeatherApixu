package ru.sulatskov.weatherapixu.main.screens.main

import ru.sulatskov.weatherapixu.base.presenter.BasePresenterInterface
import ru.sulatskov.weatherapixu.base.view.BaseViewInterface
import ru.sulatskov.weatherapixu.model.network.dto.WeatherItem

interface MainContractInterface {
    interface View : BaseViewInterface{
        fun showError()
        fun showWeatherItem(weatherItem: WeatherItem)
    }

    interface Presenter : BasePresenterInterface<View>{
        fun loadData()
    }
}