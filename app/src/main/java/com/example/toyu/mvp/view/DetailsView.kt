package com.example.toyu.mvp.view

import com.example.toyu.data.vos.ToyVO

interface DetailsView : BaseView {

    fun displayToyDetails(toy : ToyVO)
    fun navigateToBack()
    fun navigateToCart()
    fun navigateToSwap(id: String)
}