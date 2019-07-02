package ru.sulatskov.weatherapixu.model.network.dto

import com.google.gson.annotations.SerializedName

data class CurrentData(


    @SerializedName("last_updated_epoch") var lastUpdatedEpoch: Int,
    @SerializedName("last_updated") var lastUpdated: String,
    @SerializedName("temp_c") var tempC: Int,
    @SerializedName("temp_f") var tempF: Int,
    @SerializedName("is_day") var isDay: Int,
    @SerializedName("condition") var condition: ConditionData,
    @SerializedName("wind_mph") var windMph: Int,
    @SerializedName("wind_kph") var windKph: Int,
    @SerializedName("wind_degree") var windDegree: Int,
    @SerializedName("wind_dir") var windDir: Int,
    @SerializedName("pressure_mb") var pressureMb: Int,
    @SerializedName("pressure_in") var pressureIn: Int,
    @SerializedName("precip_mm") var precipMm: Int,
    @SerializedName("precip_in") var precipIn: Int,
    @SerializedName("humidity") var humidity: Int,
    @SerializedName("cloud") var cloud: Int,
    @SerializedName("feelslike_c") var feelslikeC: Int,
    @SerializedName("feelslike_f") var feelslikeF: Int,
    @SerializedName("vis_km") var visKm: Int,
    @SerializedName("vis_miles") var visMiles: Int,
    @SerializedName("uv") var uv: Int,
    @SerializedName("gust_mph") var gustMph: Int,
    @SerializedName("gust_kph") var gustKph: Int


) {
}