package ru.sulatskov.weatherapixu.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.city_list_item.view.*
import ru.sulatskov.weatherapixu.R
import ru.sulatskov.weatherapixu.model.network.dto.WeatherItem
import java.text.SimpleDateFormat
import java.util.*

class WeatherListAdapter() : RecyclerView.Adapter<WeatherListAdapter.ViewHolder>() {

    private val weathersDataList = mutableListOf<WeatherItem>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.city_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(weathersDataList[position])
    }

    fun add(item: WeatherItem) {
        val size = weathersDataList.size
        weathersDataList.add(item)
        notifyItemInserted(size)

    }

    override fun getItemCount() = weathersDataList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        val nameTextView: TextView = view.name_text_view
        val tempTextView: TextView = view.temp_C_text_view
        val timeTextView: TextView = view.time_text_view

        var format = SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.getDefault())
        var formatInTextView = SimpleDateFormat("hh:mm", Locale.getDefault())


        fun bind(weather: WeatherItem) {
            val date = format.parse(weather.localtime)

            nameTextView.text = weather.name
            timeTextView.text = formatInTextView.format(date)
            tempTextView.text = weather.tempC.toString()
        }

    }
}