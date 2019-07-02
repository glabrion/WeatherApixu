package ru.sulatskov.weatherapixu.model.network.dto

import com.google.gson.annotations.SerializedName

data class WeatherData(
    @SerializedName("location") var location: LocationData,
    @SerializedName("current") var current: CurrentData) {
}











