package ru.sulatskov.weatherapixu.model.network.dto

import com.google.gson.annotations.SerializedName

data class WeatherData(
    var location: LocationData,
    var current: CurrentData
)










