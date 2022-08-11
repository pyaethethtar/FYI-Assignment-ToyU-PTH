package com.example.toyu.delegate

import com.example.toyu.data.vos.CartVO

interface CartItemDelegate {

    fun onTapPlus(cart: CartVO)
    fun onTapMinus(cart: CartVO)
    fun onCheckedCart(cartVO: CartVO)
}