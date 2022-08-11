package com.example.toyu.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.toyu.data.model.ToyUModel
import com.example.toyu.data.model.ToyUModelImpl
import com.example.toyu.data.vos.CartVO
import com.example.toyu.mvp.presenters.AbstractBasePresenter
import com.example.toyu.mvp.presenters.CartPresenter
import com.example.toyu.mvp.view.CartView

class CartPresenterImpl : CartPresenter, AbstractBasePresenter<CartView>() {

    private val mModel : ToyUModel = ToyUModelImpl
    private lateinit var mLifecycleOwner: LifecycleOwner

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        mLifecycleOwner = lifecycleOwner
        mModel.getCartList().observe(lifecycleOwner, Observer {
            if (it.isNotEmpty()){
                mView?.displayCarts(it)
                var mTotal : Double = 0.0
                it.forEach {
                    mTotal += it.subTotal
                }
                mView?.displayTotal(mTotal)
            }
            else{
                mView?.displayTotal(0.0)
            }
        })

    }

    override fun onTapOrder() {
        mModel.clearCart()
        mView?.navigateToOrder()
    }

    override fun onTapMenu() {
        mView?.navigateToMenu()
    }

    override fun onTapNotification() {
        mView?.navigateToNotification()
    }

    override fun onTapPlus(cart: CartVO) {
        val cartVO = cart
        cartVO.quantity = cart.quantity+1
        cartVO.subTotal = cartVO.quantity * cart.toy.price
        mModel.updateCart(cartVO)

    }

    override fun onTapMinus(cart: CartVO) {
        val cartVO = cart
        cartVO.quantity = cart.quantity-1
        cartVO.subTotal = cartVO.quantity * cart.toy.price
        mModel.updateCart(cartVO)
    }

    override fun onCheckedCart(cartVO: CartVO) {
        if (cartVO.quantity==0){
            cartVO.quantity = 1
        }
        else{
            cartVO.quantity = 0
        }
        cartVO.subTotal = cartVO.quantity * cartVO.toy.price
        mModel.updateCart(cartVO)
    }
}