package com.example.toyu.mvp.view

import com.example.toyu.data.vos.ToyVO

interface FavouriteView : BaseView {

    fun displayEmpty()
    fun displayFavouriteToys(toys : List<ToyVO>)
    fun navigateToDetails(id: String)
}