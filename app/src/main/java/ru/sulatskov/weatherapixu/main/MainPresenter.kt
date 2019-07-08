package ru.sulatskov.weatherapixu.main

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.sulatskov.weatherapixu.base.presenter.BasePresenter
import ru.sulatskov.weatherapixu.model.local.CityListSharedPreferences
import ru.sulatskov.weatherapixu.model.network.dto.WeatherData
import ru.sulatskov.weatherapixu.model.network.dto.WeatherItem
import ru.sulatskov.weatherapixu.model.network.services.WeatherService

class MainPresenter(
    private val weatherService: WeatherService,
    private val preferences: CityListSharedPreferences
) : BasePresenter<MainContractInterface.View>(), MainContractInterface.Presenter {

    override fun attach(v: MainContractInterface.View) {
        super.attach(v)
        weatherService.getWeatherByName("Volgograd")
            .enqueue(object : Callback<WeatherData> {
                override fun onResponse(call: Call<WeatherData>, response: Response<WeatherData>) {
                    val body = response.body()
                    if (body != null) {
                        view?.showWeatherItem(
                            WeatherItem(
                                body.location.name,
                                body.location.localtime,
                                body.current.tempC
                            )
                        )
                    }
                }

                override fun onFailure(call: Call<WeatherData>, t: Throwable) {
                    view?.showError()
                }

            })
    }
}
