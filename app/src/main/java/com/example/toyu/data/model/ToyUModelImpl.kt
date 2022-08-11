package com.example.toyu.data.model

import androidx.lifecycle.LiveData
import com.example.toyu.data.vos.CartVO
import com.example.toyu.data.vos.ToyVO

object ToyUModelImpl : ToyUModel, BaseModel() {

    override fun saveToyListToDatabase(toyList: List<ToyVO>) {
        mTheDB.toyDao().deleteAllToys()
        mTheDB.toyDao().addAllToyList(toyList)
    }

    override fun getToyList(): LiveData<List<ToyVO>> {
        return mTheDB.toyDao().getAllToys()
    }

    override fun getToyById(toyId: String): LiveData<ToyVO> {
        return mTheDB.toyDao().getToyById(toyId)
    }

    override fun setFavoriteToy(toy: ToyVO) {
        if (toy.isFavorite){
            toy.isFavorite = false
        }
        else{
            toy.isFavorite = true
        }

        mTheDB.toyDao().updateToy(toy)
    }

    override fun getCartList(): LiveData<List<CartVO>> {
        return mTheDB.cartDao().getAllCarts()
    }

    override fun getCartById(cartId: String): LiveData<CartVO> {
        return mTheDB.cartDao().getCartById(cartId)
    }

    override fun addToCart(cart: CartVO) {
        mTheDB.cartDao().addCart(cart)
    }

    override fun updateCart(cart: CartVO) {
        mTheDB.cartDao().updateCart(cart)
    }

    override fun clearCart() {
        mTheDB.cartDao().deleteAllCarts()
    }


}