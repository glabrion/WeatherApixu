package ru.sulatskov.weatherapixu.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.city_list_item.view.*
import ru.sulatskov.weatherapixu.R
import ru.sulatskov.weatherapixu.model.network.dto.WeatherData
import ru.sulatskov.weatherapixu.model.network.dto.WeatherItem

class WeatherListAdapter(private val weathersDataList: List<WeatherItem>, private val context: Context)
                        : RecyclerView.Adapter<WeatherListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.city_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var weather: WeatherItem = weathersDataList[position]

        holder.nameTextView?.text = weather.name
        holder.timeTextView?.text = weather.localtime
        holder.tempTextView?.text = weather.tempC.toString()



    }

    override fun getItemCount() = weathersDataList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val nameTextView: TextView? = view.name_text_view
        val tempTextView: TextView? = view.temp_C_text_view
        val timeTextView: TextView? = view.time_text_view
    }
}