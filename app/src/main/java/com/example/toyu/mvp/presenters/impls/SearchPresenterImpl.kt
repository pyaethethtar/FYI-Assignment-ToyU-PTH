package com.example.toyu.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.toyu.data.model.ToyUModel
import com.example.toyu.data.model.ToyUModelImpl
import com.example.toyu.mvp.presenters.AbstractBasePresenter
import com.example.toyu.mvp.presenters.SearchPresenter
import com.example.toyu.mvp.view.SearchView

class SearchPresenterImpl : SearchPresenter, AbstractBasePresenter<SearchView>() {

    private val mModel : ToyUModel = ToyUModelImpl
    private lateinit var mLifecycleOwner: LifecycleOwner

    override fun onUiReady(keyword: String, lifecycleOwner: LifecycleOwner) {
        mLifecycleOwner = lifecycleOwner
        onTapSearch(keyword)
    }

    override fun onTapSearch(keyword: String) {
        if (keyword!=""){
            mModel.getToyList().observe(mLifecycleOwner, Observer {toys->
                if (toys.isNotEmpty()){
                    val result = toys.filter { it.toyName.contains(keyword) }
                    if (result.isNotEmpty()){
                        mView?.displaySearchResult(result)
                        mView?.displayResultCount(result.count())
                    }
                    else{
                        mView?.displayResultCount(0)
                    }
                }
            })
        }
    }

    override fun onTapBack() {
        mView?.navigateToBack()
    }

    override fun onTapToy(id: String) {
        mView?.navigateToDetails(id)
    }
}