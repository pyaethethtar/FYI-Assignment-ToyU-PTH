package com.example.toyu.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.toyu.mvp.view.DetailsView

interface DetailsPresenter : BasePresenter<DetailsView> {

    fun onUiReady(id: String, lifecycleOwner: LifecycleOwner)
    fun onTapBack()
    fun onTapFavourite()
    fun onTapAddToCart(id: String)
    fun onTapSwap(id: String)
}