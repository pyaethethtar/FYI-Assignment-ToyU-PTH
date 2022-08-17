package com.example.toyu.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.toyu.R
import com.example.toyu.data.vos.ToyImageVO
import com.example.toyu.viewholders.ToyImageViewHolder

class ToyImagesAdapter : BaseAdapter<ToyImageViewHolder, ToyImageVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToyImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_toy_image, parent, false)
        return ToyImageViewHolder(view)
    }
}