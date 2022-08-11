package com.example.toyu.mvp.view

import com.example.toyu.data.vos.ToyVO

interface SearchView : BaseView {

    fun displaySearchResult(toys: List<ToyVO>)
    fun displayResultCount(count: Int)
    fun navigateToBack()
    fun navigateToDetails(id: String)
}