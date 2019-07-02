package ru.sulatskov.weatherapixu.main

import ru.sulatskov.weatherapixu.base.presenter.BasePresenterInterface
import ru.sulatskov.weatherapixu.base.view.BaseViewInterface

interface MainContractInterface {
    interface View : BaseViewInterface{
        fun loadWeather()
    }

    interface Presenter : BasePresenterInterface<View>{
        fun onWeaterLoaded()
    }
}