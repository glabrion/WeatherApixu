package ru.sulatskov.weatherapixu

import android.app.Application
import org.koin.core.context.startKoin

open class AppApplication() : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(mainModule(applicationContext))
        }

    }
}