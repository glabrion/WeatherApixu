package ru.sulatskov.weatherapixu.main

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.sulatskov.weatherapixu.AppConfig
import ru.sulatskov.weatherapixu.base.presenter.BasePresenter
import ru.sulatskov.weatherapixu.model.network.dto.WeatherData
import ru.sulatskov.weatherapixu.model.network.services.WeatherService

class MainPresenter : BasePresenter<MainContractInterface.View>(), MainContractInterface.Presenter {
    override fun attach(v: MainContractInterface.View) {
        super.attach(v)

        WeatherService.getInstance().getWeatherByName(AppConfig.CITY_LIST[1])
            .enqueue(object : Callback<WeatherData> {
                override fun onResponse(call: Call<WeatherData>, response: Response<WeatherData>) {
                    response.body()?.let {
                        //view?.onWeatherLoaded(it.current)
                    }

                }

                override fun onFailure(call: Call<WeatherData>, t: Throwable) {
                    view?.showError()
                }

            })
    }
}
