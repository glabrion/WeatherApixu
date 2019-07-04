package ru.sulatskov.weatherapixu.model.network.services

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import ru.sulatskov.weatherapixu.AppConfig
import ru.sulatskov.weatherapixu.model.network.dto.WeatherData


interface ApiWeather {
    @GET("current.json")
    fun getWeatherByName(
        @Query("q") q : String,
        @Query("lang") lang : String,
        @Query("key") key : String = AppConfig.APIXU_API_KEY

    ): Call<WeatherData>
}