package ru.sulatskov.weatherapixu.main.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_city_list.*
import ru.sulatskov.weatherapixu.R
import ru.sulatskov.weatherapixu.base.view.BaseActivity
import ru.sulatskov.weatherapixu.main.MainContractInterface
import ru.sulatskov.weatherapixu.main.MainFragment
import ru.sulatskov.weatherapixu.main.MainPresenter
import ru.sulatskov.weatherapixu.model.network.dto.WeatherData
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : BaseActivity(), MainContractInterface.View {

    private val presenter: MainContractInterface.Presenter =
        MainPresenter()
    private lateinit var linearLayoutManager: LinearLayoutManager

    override val layoutResId: Int
        get() = R.layout.activity_main

    override fun init(state: Bundle?) {
        presenter.attach(this)
        supportFragmentManager.beginTransaction().add(R.id.main_fragment_container,
            MainFragment()
        ).commit()

        linearLayoutManager = LinearLayoutManager(this)
        city_list_recycler_view.layoutManager = linearLayoutManager
    }


    override fun onWeatherLoaded(response: WeatherData?) {
        if (response != null) {
            var format = SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.getDefault())
            var formatInTextView = SimpleDateFormat("hh:mm", Locale.getDefault())
            var date = format.parse(response.location.localtime)

       //     time_text_view.text = formatInTextView.format(date)
       //     name_text_view.text = response.location.name
       //     temp_C_text_view.text = response.current.tempC.toString()  + "  ℃"


        }
    }

    override fun showError() {
        Toast.makeText(this, "Ошибка загрузки данных", Toast.LENGTH_SHORT).show()
    }

}
