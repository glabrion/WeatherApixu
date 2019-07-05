package ru.sulatskov.weatherapixu.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fragment_city_list.view.*
import org.koin.android.ext.android.inject
import ru.sulatskov.weatherapixu.R
import ru.sulatskov.weatherapixu.model.network.dto.WeatherItem

class MainFragment : Fragment(), MainContractInterface.View {
    private val presenter: MainContractInterface.Presenter by inject()

    //    val weathers = mutableListOf<WeatherItem>()
    private val weatherListAdapter = WeatherListAdapter()
    private val TAG = MainFragment::class.java.simpleName

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        presenter.attach(this)
        val view = inflater.inflate(R.layout.fragment_city_list, container, false)

//        view.add_city.setOnClickListener {
//        }


        view.city_list_recycler_view.layoutManager = LinearLayoutManager(view.context)
        view.city_list_recycler_view.adapter = weatherListAdapter

        return view
    }

    override fun showWeatherItem(weatherItem: WeatherItem) {
        weatherListAdapter.add(weatherItem)
    }


/*
    override fun onWeatherLoaded(response: WeatherData?) {
        if (response != null) {


            weathers.add(WeatherItem(response.location.name, formatInTextView.format(date), response.current.tempC))
        }
    }*/

    override fun showError() {
        Toast.makeText(activity, "Ошибка загрузки данных", Toast.LENGTH_SHORT).show()
    }


}