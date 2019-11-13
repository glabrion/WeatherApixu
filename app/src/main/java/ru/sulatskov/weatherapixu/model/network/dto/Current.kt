package ru.sulatskov.weatherapixu.model.network.dto

import com.google.gson.annotations.SerializedName

class Current(
    @SerializedName("temperature")
    var temperature: Float
)