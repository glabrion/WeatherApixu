package ru.sulatskov.weatherapixu.model.local

import android.content.Context

class CityListSharedPreferences private constructor() {


    companion object {

        private var INSTANCE: CityListSharedPreferences? = null

        fun getInstance(): CityListSharedPreferences {
            if (INSTANCE == null) {
                INSTANCE = CityListSharedPreferences()
            }
            return INSTANCE!!
        }

    }



}