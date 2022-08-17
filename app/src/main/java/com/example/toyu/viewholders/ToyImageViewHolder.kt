package com.example.toyu.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.toyu.data.vos.ToyImageVO
import kotlinx.android.synthetic.main.viewholder_toy_image.view.*

class ToyImageViewHolder(itemView: View) : BaseViewHolder<ToyImageVO>(itemView) {

    override fun bindData(data: ToyImageVO) {
        Glide.with(itemView.context).load(data.imageUrl).into(itemView.ivToy)
    }
}