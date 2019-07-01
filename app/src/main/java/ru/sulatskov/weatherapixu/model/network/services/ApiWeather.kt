package ru.sulatskov.weatherapixu.model.network.services

import retrofit2.Call
import retrofit2.http.POST
import ru.sulatskov.weatherapixu.model.network.dto.WeatherData


interface ApiWeather {
    @POST("authorizations")
    fun login(): Call<WeatherData>
}