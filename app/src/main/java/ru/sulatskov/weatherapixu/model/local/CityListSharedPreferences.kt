package ru.sulatskov.weatherapixu.model.local

import android.content.Context

class CityListSharedPreferences private constructor(context: Context) {

    private val prefs = context.getSharedPreferences("weather", Context.MODE_PRIVATE)


    companion object {

        private lateinit var INSTANCE: CityListSharedPreferences

        fun getInstance(context: Context): CityListSharedPreferences {
            if (!::INSTANCE.isInitialized) {
                INSTANCE = CityListSharedPreferences(context)
            }
            return INSTANCE
        }

        private const val citiesKey = "citiesKey"
    }

    fun getCities(): MutableSet<String> = prefs.getStringSet(citiesKey, mutableSetOf())!!


    fun addCity(value: String) {
        val cities = getCities()
        cities.add(value)
        prefs.edit().putStringSet(citiesKey, cities).apply()
    }
}