package ru.sulatskov.weatherapixu.main.screens.main


import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.sulatskov.weatherapixu.AppConfig
import ru.sulatskov.weatherapixu.base.presenter.BasePresenter
import ru.sulatskov.weatherapixu.model.network.dto.WeatherData
import ru.sulatskov.weatherapixu.model.network.dto.WeatherItem
import ru.sulatskov.weatherapixu.model.network.services.WeatherService

class MainPresenter(
    private val weatherService: WeatherService
) : BasePresenter<MainContractInterface.View>(), MainContractInterface.Presenter {

    override fun attach(view: MainContractInterface.View) {
        super.attach(view)
        loadData()
    }

    override fun loadData() {
        AppConfig.CITY_LIST.forEach {
            weatherService.getWeatherByName(it)
                .map { weatherData: WeatherData ->
                    WeatherItem(
                        weatherData.location.name,
                        weatherData.location.localtime,
                        weatherData.current.temperature
                    )
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { weatherItem, error ->
                    error?.let {
                        view?.showError()
                    }
                    weatherItem?.let {
                        view?.showWeatherItem(weatherItem)
                    }
                }
        }
    }
}
