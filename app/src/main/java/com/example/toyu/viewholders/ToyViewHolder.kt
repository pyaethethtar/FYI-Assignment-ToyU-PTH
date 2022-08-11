package com.example.toyu.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.toyu.R
import com.example.toyu.delegate.ToyItemDelegate
import com.example.toyu.data.vos.ToyVO
import com.example.toyu.utils.TOY_CATEGORY_NEW
import kotlinx.android.synthetic.main.viewholder_toy.view.*
import kotlinx.android.synthetic.main.viewholder_toy.view.ivToy

class ToyViewHolder(itemView: View,val delegate: ToyItemDelegate) : BaseViewHolder<ToyVO>(itemView) {

    override fun bindData(data: ToyVO) {
        Glide.with(itemView.context).load(data.imageList.first().imageUrl).into(itemView.ivToy)
        itemView.tvToyName.text = data.toyName
        itemView.tvToyType.text = data.toyCategory
        showToyType(data.toyCategory)

        itemView.btnDetails.setOnClickListener {
            delegate.onTapToy(data.toyId)
        }
    }

    private fun showToyType(type: String){
        if (type== TOY_CATEGORY_NEW){
            itemView.tvToyType.setTextColor(itemView.resources.getColor(R.color.colorPrimary))
        }
        else{
            itemView.tvToyType.setTextColor(itemView.resources.getColor(R.color.colorSecondaryLight))
        }
    }
}