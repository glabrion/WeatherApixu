package ru.sulatskov.weatherapixu.model.network.services

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.sulatskov.weatherapixu.AppConfig
import ru.sulatskov.weatherapixu.model.network.dto.WeatherData


interface ApiWeather {
    @GET("current")
    fun getWeatherByName(
        @Query("access_key")
        key: String = AppConfig.APIXU_API_KEY,
        @Query("query")
        query: String,
        @Query("lang")
        lang: String
    ): Single<WeatherData>
}