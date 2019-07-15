package ru.sulatskov.weatherapixu.main


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

    override fun attach(v: MainContractInterface.View) {
        super.attach(v)

        AppConfig.CITY_LIST.forEach {
            weatherService.getWeatherByName(it)
                .map { weatherData: WeatherData ->
                    WeatherItem(weatherData.location.name, weatherData.location.localtime, weatherData.current.tempC)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { weatherItem, error ->
                    if (error != null) {
                        view?.showError()
                    } else if (weatherItem != null) {
                        view?.showWeatherItem(weatherItem)
                    }
                }
        }
    }
}
