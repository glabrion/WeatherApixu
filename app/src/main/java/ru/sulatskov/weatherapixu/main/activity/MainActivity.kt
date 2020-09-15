package ru.sulatskov.weatherapixu.main.activity

import android.os.Bundle
import ru.sulatskov.weatherapixu.R
import ru.sulatskov.weatherapixu.base.view.BaseActivity
import ru.sulatskov.weatherapixu.main.MainFragment

class MainActivity : BaseActivity() {

    override val layoutResId: Int
        get() = R.layout.activity_main

    override fun init(state: Bundle?) {
        openGeneralFragment()
    }

    fun openGeneralFragment() {
        supportFragmentManager.beginTransaction().replace(
            R.id.main_fragment_container,
            MainFragment()
        ).commit()
    }

}
