package ru.sulatskov.weatherapixu.main

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.city_list_item.view.*
import ru.sulatskov.weatherapixu.R
import ru.sulatskov.weatherapixu.model.network.dto.WeatherItem
import java.text.SimpleDateFormat
import java.util.*

class WeatherListAdapter : RecyclerView.Adapter<WeatherListAdapter.ViewHolder>() {

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


        private val nameTextView: TextView = view.name_text_view
        private val tempTextView: TextView = view.temp_C_text_view
        private val timeTextView: TextView = view.time_text_view

        private var format = SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.getDefault())
        private var formatInTextView = SimpleDateFormat("hh:mm", Locale.getDefault())

        fun bind(weather: WeatherItem) {
            val date = format.parse(weather.localtime)

            nameTextView.text = weather.name
            timeTextView.text = formatInTextView.format(date)
            val tempC = weather.tempC.toString()
            tempTextView.text = String.format(itemView.context.getString(R.string.temp), tempC)
        }

    }
}

class SimpleDividerItemDecoration(context: Context) : RecyclerView.ItemDecoration() {
    private val mDivider: Drawable = context?.getDrawable( R.drawable.items_divider)

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight + 10

        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)

            val params = child.layoutParams as RecyclerView.LayoutParams

            val top = child.bottom + params.bottomMargin
            val bottom = top + mDivider.intrinsicHeight

            mDivider.setBounds(left, top, right, bottom)
            mDivider.draw(c)
        }
    }
}
