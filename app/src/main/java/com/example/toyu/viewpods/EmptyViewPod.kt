package com.example.toyu.viewpods

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.LinearLayoutCompat

class EmptyViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayoutCompat(context, attrs) {

    override fun onFinishInflate() {
        super.onFinishInflate()
    }
}