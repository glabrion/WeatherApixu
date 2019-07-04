package ru.sulatskov.weatherapixu.model.network.services

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.sulatskov.weatherapixu.AppConfig
import ru.sulatskov.weatherapixu.model.network.dto.WeatherData
import java.util.*


class WeatherService private constructor() {

    companion object {

        private var INSTANCE: WeatherService? = null

        fun getInstance(): WeatherService {
            if (INSTANCE == null) {
                INSTANCE = WeatherService()
            }
            return INSTANCE!!
        }

    }

    private var retrofit: ApiWeather = Retrofit.Builder()
        .baseUrl(AppConfig.APIXU_API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiWeather::class.java)


    fun getWeatherByName(q : String, lang : String = Locale.getDefault().language.toLowerCase()): Call<WeatherData> {
        return retrofit.getWeatherByName(q, lang)
    }


}