package com.example.toyu.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.toyu.R
import com.example.toyu.viewholders.PromotionViewHolder
import com.example.toyu.data.vos.ToyVO

class PromotionAdapter : BaseAdapter<PromotionViewHolder, ToyVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromotionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_promotion, parent, false)
        return PromotionViewHolder(view)
    }
}