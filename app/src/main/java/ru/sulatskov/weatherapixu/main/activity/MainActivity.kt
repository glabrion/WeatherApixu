package ru.sulatskov.weatherapixu.main.activity

import android.content.res.AssetManager
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.city_list_item.*
import kotlinx.android.synthetic.main.fragment_city_list.*
import ru.sulatskov.weatherapixu.R
import ru.sulatskov.weatherapixu.base.view.BaseActivity
import ru.sulatskov.weatherapixu.main.MainContractInterface
import ru.sulatskov.weatherapixu.main.MainFragment
import ru.sulatskov.weatherapixu.main.MainPresenter
import ru.sulatskov.weatherapixu.model.network.dto.WeatherData
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : BaseActivity() {


    override val layoutResId: Int
        get() = R.layout.activity_main

    override fun init(state: Bundle?) {
        supportFragmentManager.beginTransaction().add(R.id.main_fragment_container,
            MainFragment()
        ).commit()
    }

}
