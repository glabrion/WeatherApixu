package ru.sulatskov.weatherapixu.main.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_city_list.view.*
import org.koin.android.ext.android.inject
import ru.sulatskov.weatherapixu.R
import ru.sulatskov.weatherapixu.main.activity.MainActivity
import ru.sulatskov.weatherapixu.model.network.dto.WeatherItem


class MainFragment : Fragment(), MainContractInterface.View {
    private val presenter: MainContractInterface.Presenter by inject()
    private val weatherListAdapter = WeatherListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_city_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
        view.city_list_recycler_view.layoutManager =
            androidx.recyclerview.widget.LinearLayoutManager(view.context)
        view.city_list_recycler_view.adapter = weatherListAdapter
        view.context?.let {
            view.city_list_recycler_view.addItemDecoration(SimpleDividerItemDecoration(it))
        }

        view.swipe_container?.setOnRefreshListener{
            (activity as? MainActivity)?.openGeneralFragment()
        }
    }

    override fun showWeatherItem(weatherItem: WeatherItem) {
        weatherListAdapter.add(weatherItem)
    }

    override fun showError() {
        Toast.makeText(activity, getString(R.string.error_text), Toast.LENGTH_SHORT).show()
    }


}