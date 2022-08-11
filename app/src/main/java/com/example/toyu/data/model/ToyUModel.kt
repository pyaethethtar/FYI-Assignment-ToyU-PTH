package com.example.toyu.data.model

import androidx.lifecycle.LiveData
import com.example.toyu.data.vos.CartVO
import com.example.toyu.data.vos.ToyVO

interface ToyUModel  {

    fun saveToyListToDatabase(toyList: List<ToyVO>)
    fun getToyList() : LiveData<List<ToyVO>>
    fun getToyById(toyId: String) : LiveData<ToyVO>
    fun setFavoriteToy(toy : ToyVO)
    fun getCartList() : LiveData<List<CartVO>>
    fun getCartById(cartId: String) : LiveData<CartVO>
    fun addToCart(cart: CartVO)
    fun updateCart(cart: CartVO)
    fun clearCart()
}