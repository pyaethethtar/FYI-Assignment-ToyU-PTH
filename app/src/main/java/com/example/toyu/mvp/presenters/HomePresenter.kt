package com.example.toyu.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.toyu.delegate.ToyItemDelegate
import com.example.toyu.mvp.view.HomeView

interface HomePresenter : BasePresenter<HomeView>, ToyItemDelegate {

    fun onUiReady(lifecycleOwner: LifecycleOwner)
    fun onTapSearch(keyword: String?)
    fun onTapFilter()
    fun onTapMenu()
    fun onTapNotification()
}