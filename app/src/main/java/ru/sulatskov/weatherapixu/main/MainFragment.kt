package ru.sulatskov.weatherapixu.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.city_list_item.*
import kotlinx.android.synthetic.main.fragment_city_list.*
import kotlinx.android.synthetic.main.fragment_city_list.view.*
import ru.sulatskov.weatherapixu.R
import ru.sulatskov.weatherapixu.model.network.dto.CurrentData
import ru.sulatskov.weatherapixu.model.network.dto.LocationData
import ru.sulatskov.weatherapixu.model.network.dto.WeatherData
import ru.sulatskov.weatherapixu.model.network.dto.WeatherItem
import java.text.SimpleDateFormat
import java.util.*

class MainFragment : Fragment(), MainContractInterface.View {

    private val presenter: MainContractInterface.Presenter =
        MainPresenter()

    val weathers = mutableListOf<WeatherItem>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        presenter.attach(this)


        val view = inflater.inflate(R.layout.fragment_city_list, container, false)



        view.city_list_recycler_view.layoutManager = LinearLayoutManager(view.context)

        view.city_list_recycler_view.adapter = WeatherListAdapter(weathers, view.context)



        return view
    }

    fun addWeather() {
        weathers.add(WeatherItem("Volgograd", "2019-07-04 12:53", 23f))
        weathers.add(WeatherItem("Tumen", "2019-07-04 14:53", 26f))
    }

    override fun onWeatherLoaded(response: WeatherData?) {
        if (response != null) {


        }
    }

    override fun showError() {
        Toast.makeText(activity, "Ошибка загрузки данных", Toast.LENGTH_SHORT).show()
    }


    /*var format = SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.getDefault())
    var formatInTextView = SimpleDateFormat("hh:mm", Locale.getDefault())
    var date = format.parse(response.location.localtime)

    itemView?.time_text_view.text = formatInTextView.format(date)
    name_text_view.text = response.location.name
    temp_C_text_view.text = response.current.tempC.toString()  + "  ℃"
*/


}