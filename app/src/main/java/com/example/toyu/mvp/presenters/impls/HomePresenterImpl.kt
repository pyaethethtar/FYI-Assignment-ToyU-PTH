package com.example.toyu.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.toyu.data.model.ToyUModel
import com.example.toyu.data.model.ToyUModelImpl
import com.example.toyu.dummy.getDummyToyList
import com.example.toyu.mvp.presenters.AbstractBasePresenter
import com.example.toyu.mvp.presenters.HomePresenter
import com.example.toyu.mvp.view.HomeView

class HomePresenterImpl : HomePresenter, AbstractBasePresenter<HomeView>() {

    private val mModel : ToyUModel = ToyUModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {

        mModel.getToyList().observe(lifecycleOwner, Observer {
            if (it.isNotEmpty()){
                mView?.displayToys(it)
                val promotionToyList = it.filter { (it.promotionType!=null) }
                mView?.displayPromotionToys(promotionToyList)
            }
            else{
                mModel.saveToyListToDatabase(getDummyToyList())
            }
        })
    }

    override fun onTapSearch(keyword: String?) {
        mView?.navigateToSearch(keyword)
    }

    override fun onTapFilter() {
        mView?.navigateToFilter()
    }

    override fun onTapMenu() {
        mView?.navigateToMenu()
    }

    override fun onTapNotification() {
        mView?.navigateToNotification()
    }

    override fun onTapToy(id: String) {
        mView?.navigateToDetails(id)
    }
}