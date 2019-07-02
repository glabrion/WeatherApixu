package ru.sulatskov.weatherapixu.main

import android.os.Bundle
import ru.sulatskov.weatherapixu.R
import ru.sulatskov.weatherapixu.base.view.BaseActivity

class MainActivity : BaseActivity(), MainContractInterface.View {

    private lateinit var presenter: MainContractInterface.Presenter

    override val layoutResId: Int
        get() = R.layout.activity_main

    override fun init(state: Bundle?) {
        presenter = MainPresenter()
        presenter.attach(this)
    }

    override fun loadWeather() {
    }

}
