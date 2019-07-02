package ru.sulatskov.weatherapixu.model.network.dto

import com.google.gson.annotations.SerializedName

data class LocationData(

    @SerializedName("name") var name: String,
    @SerializedName("region") var region: String,
    @SerializedName("country") var country: String,
    @SerializedName("lat") var lat: Int,
    @SerializedName("lon") var lon: Int,
    @SerializedName("tz_id") var TzId: String,
    @SerializedName("localtime_epoch") var LocaltimeEpoch: Int,
    @SerializedName("localtime") var localtime: String

    ) {

}