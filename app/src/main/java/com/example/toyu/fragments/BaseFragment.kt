package com.example.toyu.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.toyu.mvp.view.BaseView
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragment : Fragment(), BaseView {

    private lateinit var mView: View
    private lateinit var mContext : Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mView = view
    }

    override fun displayMessage(message: String) {
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }


}