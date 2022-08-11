package com.example.toyu.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.toyu.delegate.CartItemDelegate
import com.example.toyu.mvp.view.CartView

interface CartPresenter : CartItemDelegate, BasePresenter<CartView> {

    fun onUiReady(lifecycleOwner: LifecycleOwner)
    fun onTapOrder()
    fun onTapMenu()
    fun onTapNotification()
}