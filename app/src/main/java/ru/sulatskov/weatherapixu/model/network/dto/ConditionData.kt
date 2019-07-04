package ru.sulatskov.weatherapixu.model.network.dto

import com.google.gson.annotations.SerializedName

data class ConditionData(

    @SerializedName("text") var text: String,
    @SerializedName("icon") var icon: String,
    @SerializedName("code") var code: Float
) {
}