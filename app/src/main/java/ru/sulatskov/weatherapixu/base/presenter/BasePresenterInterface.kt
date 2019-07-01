package ru.sulatskov.weatherapixu.base.presenter

import ru.sulatskov.weatherapixu.base.view.BaseViewInterface

interface BasePresenterInterface<V: BaseViewInterface> {

    val isAttached: Boolean

    fun attach(view: V)

    fun detach()


}