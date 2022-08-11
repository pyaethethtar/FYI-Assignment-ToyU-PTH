package com.example.toyu.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.toyu.delegate.ToyItemDelegate
import com.example.toyu.mvp.view.SearchView

interface SearchPresenter : ToyItemDelegate, BasePresenter<SearchView> {

    fun onUiReady(keyword: String, lifecycleOwner: LifecycleOwner)
    fun onTapSearch(keyword: String)
    fun onTapBack()
}