package com.example.toyu.mvp.view

import com.example.toyu.data.vos.CartVO

interface CartView : BaseView {

    fun displayCarts(carts : List<CartVO>)
    fun displayTotal(total : Double)
    fun navigateToMenu()
    fun navigateToNotification()
    fun navigateToOrder()
}