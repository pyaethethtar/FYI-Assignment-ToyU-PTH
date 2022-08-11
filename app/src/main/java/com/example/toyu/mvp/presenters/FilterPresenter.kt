package com.example.toyu.mvp.presenters

import com.example.toyu.mvp.view.FilterView

interface FilterPresenter : BasePresenter<FilterView> {

    fun onTapBack()
    fun onChooseToyCategory(toyCategory: String)
    fun onChooseAgeCategory(ageCategory: String)
    fun onTapSetDefault()
    fun onTapApplyFilter(toyCategory: String, ageCategory: String, price: Int, isSetAverage: Boolean)
}