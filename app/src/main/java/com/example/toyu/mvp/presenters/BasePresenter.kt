package com.example.toyu.mvp.presenters

import com.example.toyu.mvp.view.BaseView

interface BasePresenter<T : BaseView> {

    fun initPresenter(view: T)
}