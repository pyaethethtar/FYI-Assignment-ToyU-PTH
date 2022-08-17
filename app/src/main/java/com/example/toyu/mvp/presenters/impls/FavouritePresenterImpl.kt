package com.example.toyu.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.toyu.data.model.ToyUModel
import com.example.toyu.data.model.ToyUModelImpl
import com.example.toyu.mvp.presenters.AbstractBasePresenter
import com.example.toyu.mvp.presenters.FavouritePresenter
import com.example.toyu.mvp.view.FavouriteView

class FavouritePresenterImpl: FavouritePresenter, AbstractBasePresenter<FavouriteView>() {

    private val mModel : ToyUModel = ToyUModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        mModel.getToyList().observe(lifecycleOwner, Observer { toys->
            if (toys.isNotEmpty()){
                val result = toys.filter { it.isFavorite==true }
                if (result.isNotEmpty()){
                    mView?.displayFavouriteToys(result)
                }
                else{
                    mView?.displayEmpty()
                }
            }
            else{
                mView?.displayEmpty()
            }
        })
    }

    override fun onTapToy(id: String) {
        mView?.navigateToDetails(id)
    }
}