package com.example.toyu.mvp.view

interface FilterView : BaseView {

    fun navigateToBack()
    fun showSelectedToyCategory(toyCategory : String)
    fun showSelectedAgeCategory(ageCategory : String)
    fun clearAll()
    fun showFilterResult(toyCategory: String, ageCategory: String, price: Int, isSetAverage: Boolean)
}