package com.example.toyu.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.toyu.R
import com.example.toyu.delegate.CartItemDelegate
import com.example.toyu.data.vos.CartVO
import kotlinx.android.synthetic.main.viewholder_cart.view.*

class CartViewHolder(itemView: View, val delegate: CartItemDelegate) : BaseViewHolder<CartVO>(itemView) {


    override fun bindData(data: CartVO) {
        Glide.with(itemView.context).load(data.toy.imageList.first().imageUrl).into(itemView.ivToy)
        itemView.tvToyType.text = data.toy.toyCategory
        itemView.tvToyName.text = data.toy.toyName
        Glide.with(itemView.context).load(data.toy.owner.profileImage).circleCrop().into(itemView.ivOwner)
        itemView.tvOwner.text = data.toy.owner.userName
        itemView.tvLeftCount.text = data.toy.itemCount.toString()+itemView.context.resources.getText(R.string.tv_item_left)
        itemView.tvSubTotal.text = data.subTotal.toString()
        itemView.tvCount.text = data.quantity.toString()
        if (data.quantity==0){
            itemView.btnCheck.setImageDrawable(itemView.context.resources.getDrawable(R.drawable.cart_unchecked))
        }
        else{
            itemView.btnCheck.setImageDrawable(itemView.context.resources.getDrawable(R.drawable.cart_checked))
        }


        itemView.btnPlus.setOnClickListener {
            delegate.onTapPlus(data)
        }
        itemView.btnMinus.setOnClickListener {
            delegate.onTapMinus(data)
        }
        itemView.btnCheck.setOnClickListener {
            delegate.onCheckedCart(data)
        }

    }
}