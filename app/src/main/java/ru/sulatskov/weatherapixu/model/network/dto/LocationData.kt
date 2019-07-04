package ru.sulatskov.weatherapixu.model.network.dto

import com.google.gson.annotations.SerializedName
import java.util.*

data class LocationData(

    @SerializedName("name") var name: String,
    @SerializedName("localtime") var localtime: String

    ) {

}