package com.example.toyu.mvp.presenters.impls

import com.example.toyu.mvp.presenters.AbstractBasePresenter
import com.example.toyu.mvp.presenters.FilterPresenter
import com.example.toyu.mvp.view.FilterView

class FilterPresenterImpl : FilterPresenter, AbstractBasePresenter<FilterView>() {

    override fun onTapBack() {
        mView?.navigateToBack()
    }

    override fun onChooseToyCategory(toyCategory: String) {
        mView?.showSelectedToyCategory(toyCategory)
    }

    override fun onChooseAgeCategory(ageCategory: String) {
        mView?.showSelectedAgeCategory(ageCategory)
    }

    override fun onTapSetDefault() {
        mView?.clearAll()
    }

    override fun onTapApplyFilter(
        toyCategory: String,
        ageCategory: String,
        price: Int,
        isSetAverage: Boolean
    ) {
        mView?.showFilterResult(toyCategory, ageCategory, price, isSetAverage)
    }
}