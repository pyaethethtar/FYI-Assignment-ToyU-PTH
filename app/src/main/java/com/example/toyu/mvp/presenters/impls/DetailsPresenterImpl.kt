package com.example.toyu.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.toyu.data.model.ToyUModel
import com.example.toyu.data.model.ToyUModelImpl
import com.example.toyu.data.vos.CartVO
import com.example.toyu.mvp.presenters.AbstractBasePresenter
import com.example.toyu.mvp.presenters.DetailsPresenter
import com.example.toyu.mvp.view.DetailsView
import com.example.toyu.data.vos.ToyVO

class DetailsPresenterImpl : DetailsPresenter, AbstractBasePresenter<DetailsView>() {

    private val mModel : ToyUModel = ToyUModelImpl
    private var mToy = ToyVO()
    private lateinit var mLifecycleOwner: LifecycleOwner

    override fun onUiReady(id: String, lifecycleOwner: LifecycleOwner) {
        mLifecycleOwner = lifecycleOwner
        mModel.getToyById(id).observe(lifecycleOwner, Observer {
            mToy = it
            mView?.displayToyDetails(mToy)
        })
    }

    override fun onTapBack() {
        mView?.navigateToBack()
    }

    override fun onTapFavourite() {
        mModel.setFavoriteToy(mToy)
    }

    override fun onTapAddToCart(id: String) {
        mModel.getToyById(id).observe(mLifecycleOwner, Observer {
            val cart = CartVO()
            cart.cartId = it.toyId
            cart.toy = it
            cart.quantity = 1
            cart.subTotal = it.price * cart.quantity
            mModel.addToCart(cart)
            mView?.navigateToCart()
        })
    }

    override fun onTapSwap(id: String) {
        mView?.navigateToSwap(id)
    }
}