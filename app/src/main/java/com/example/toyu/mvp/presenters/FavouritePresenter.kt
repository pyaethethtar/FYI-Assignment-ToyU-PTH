package com.example.toyu.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.toyu.delegate.ToyItemDelegate
import com.example.toyu.mvp.view.FavouriteView

interface FavouritePresenter : ToyItemDelegate, BasePresenter<FavouriteView> {

    fun onUiReady(lifecycleOwner: LifecycleOwner)
}