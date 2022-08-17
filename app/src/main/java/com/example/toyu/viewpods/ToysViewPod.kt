package com.example.toyu.viewpods

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.toyu.adapters.ToysAdapter
import com.example.toyu.data.vos.ToyVO
import com.example.toyu.delegate.ToyItemDelegate
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.viewpod_toys.view.*

class ToysViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private lateinit var mAdapter : ToysAdapter

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun setUpAdapter(delegate: ToyItemDelegate){
        mAdapter = ToysAdapter(delegate)
        rvToys.adapter = mAdapter
        rvToys.layoutManager = StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL)
    }

    fun displayToys(toys: List<ToyVO>){
        mAdapter.setNewData(toys)
    }
}