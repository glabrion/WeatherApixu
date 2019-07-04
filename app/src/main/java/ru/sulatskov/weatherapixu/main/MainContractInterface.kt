package ru.sulatskov.weatherapixu.main

import ru.sulatskov.weatherapixu.base.presenter.BasePresenterInterface
import ru.sulatskov.weatherapixu.base.view.BaseViewInterface
import ru.sulatskov.weatherapixu.model.network.dto.WeatherData

interface MainContractInterface {
    interface View : BaseViewInterface{
        fun onWeatherLoaded(response: WeatherData?)
        fun showError()
    }

    interface Presenter : BasePresenterInterface<View>{
    }
}