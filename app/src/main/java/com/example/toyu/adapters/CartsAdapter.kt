package com.example.toyu.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.toyu.R
import com.example.toyu.delegate.CartItemDelegate
import com.example.toyu.viewholders.CartViewHolder
import com.example.toyu.data.vos.CartVO

class CartsAdapter(val delegate: CartItemDelegate) : BaseAdapter<CartViewHolder, CartVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_cart, parent, false)
        return CartViewHolder(view, delegate)
    }
}