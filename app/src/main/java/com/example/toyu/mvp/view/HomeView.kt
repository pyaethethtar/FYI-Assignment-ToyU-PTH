package com.example.toyu.mvp.view

import com.example.toyu.data.vos.ToyVO

interface HomeView : BaseView {

    fun displayToys(toys : List<ToyVO>)
    fun displayPromotionToys(toys: List<ToyVO>)
    fun navigateToDetails(id : String)
    fun navigateToFilter()
    fun navigateToSearch(keyword : String?)
    fun navigateToMenu()
    fun navigateToNotification()
}