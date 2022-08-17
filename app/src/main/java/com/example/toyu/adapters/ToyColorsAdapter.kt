package com.example.toyu.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.toyu.R
import com.example.toyu.data.vos.ToyImageVO
import com.example.toyu.viewholders.ToyColorViewHolder

class ToyColorsAdapter : BaseAdapter<ToyColorViewHolder, ToyImageVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToyColorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_toy_color, parent, false)
        return ToyColorViewHolder(view)
    }
}