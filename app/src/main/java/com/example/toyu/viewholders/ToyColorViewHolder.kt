package com.example.toyu.viewholders

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.View
import com.example.toyu.data.vos.ToyImageVO
import kotlinx.android.synthetic.main.viewholder_toy_color.view.*

class ToyColorViewHolder(itemView: View) : BaseViewHolder<ToyImageVO>(itemView) {

    @SuppressLint("Range")
    override fun bindData(data: ToyImageVO) {
        itemView.ivToyColor.setBackgroundColor(Color.parseColor(data.colorCode))
    }
}