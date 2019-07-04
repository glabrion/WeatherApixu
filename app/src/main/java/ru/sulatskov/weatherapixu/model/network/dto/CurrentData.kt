package ru.sulatskov.weatherapixu.model.network.dto

import com.google.gson.annotations.SerializedName

data class CurrentData(@SerializedName("temp_c") var tempC: Float)