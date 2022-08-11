package com.example.toyu.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.toyu.R
import com.example.toyu.delegate.ToyItemDelegate
import com.example.toyu.data.vos.ToyVO
import com.example.toyu.viewholders.ToyViewHolder

class ToysAdapter(val delegate: ToyItemDelegate) : BaseAdapter<ToyViewHolder, ToyVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_toy, parent, false)
        return ToyViewHolder(view, delegate)
    }
}