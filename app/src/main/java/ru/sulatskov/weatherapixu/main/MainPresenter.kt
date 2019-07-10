package ru.sulatskov.weatherapixu.main


import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.sulatskov.weatherapixu.AppConfig
import ru.sulatskov.weatherapixu.base.presenter.BasePresenter
import ru.sulatskov.weatherapixu.model.local.CityListSharedPreferences
import ru.sulatskov.weatherapixu.model.network.dto.WeatherItem
import ru.sulatskov.weatherapixu.model.network.services.WeatherService

class MainPresenter(
    private val weatherService: WeatherService,
    private val preferences: CityListSharedPreferences
) : BasePresenter<MainContractInterface.View>(), MainContractInterface.Presenter {

    override fun attach(v: MainContractInterface.View) {
        super.attach(v)

        AppConfig.CITY_LIST.forEach {
            weatherService.getWeatherByName(it)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { response, error ->
                    if (error != null) {
                        view?.showError()
                    } else if (response != null) {
                        view?.showWeatherItem(
                            WeatherItem(
                                response.location.name,
                                response.location.localtime,
                                response.current.tempC
                            )
                        )
                    }
                }
        }
    }
}
