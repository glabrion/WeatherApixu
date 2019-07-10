package ru.sulatskov.weatherapixu.model.network.services

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.sulatskov.weatherapixu.AppConfig
import ru.sulatskov.weatherapixu.model.network.dto.WeatherData
import java.util.*


class WeatherService {

    private var retrofit: ApiWeather = Retrofit.Builder()
        .baseUrl(AppConfig.APIXU_API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(ApiWeather::class.java)


    fun getWeatherByName(q: String, lang: String = Locale.getDefault().language.toLowerCase()): Single<WeatherData> {

        return retrofit.getWeatherByName(q, lang)
    }


}