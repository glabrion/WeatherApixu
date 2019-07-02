package ru.sulatskov.weatherapixu.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.sulatskov.weatherapixu.R
import ru.sulatskov.weatherapixu.model.network.dto.WeatherData

class WeatherListAdapter(private val listCity: ArrayList<WeatherData>)
                        : RecyclerView.Adapter<WeatherListAdapter.ViewHolder>() {

    lateinit var inflater: LayoutInflater
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

        val view: View = inflater.inflate(R.layout.city_list_item, p0, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
    }

    override fun getItemCount() = listCity.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }
}