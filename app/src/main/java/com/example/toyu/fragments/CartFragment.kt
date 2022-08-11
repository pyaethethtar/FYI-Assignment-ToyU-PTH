package com.example.toyu.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.toyu.R
import com.example.toyu.adapters.CartsAdapter
import com.example.toyu.mvp.presenters.CartPresenter
import com.example.toyu.mvp.presenters.impls.CartPresenterImpl
import com.example.toyu.mvp.view.CartView
import com.example.toyu.data.vos.CartVO
import kotlinx.android.synthetic.main.fragment_cart.*


class CartFragment : BaseFragment(), CartView {

    private lateinit var mContext: Context
    private lateinit var mAdapter: CartsAdapter
    private lateinit var mPresenter: CartPresenter

    companion object{
        fun newInstance() : CartFragment{
            return CartFragment()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()
        setUpAdapter()
        setUpListeners()
        mPresenter.onUiReady(this)
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProvider(this).get(CartPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpAdapter(){
        mAdapter = CartsAdapter(mPresenter)
        rvCarts.adapter = mAdapter
        rvCarts.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false)
    }

    private fun setUpListeners(){
        btnOrder.setOnClickListener {
            mPresenter.onTapOrder()
        }
        btnMenu.setOnClickListener {
            mPresenter.onTapMenu()
        }
        btnNoti.setOnClickListener {
            mPresenter.onTapNotification()
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun displayCarts(carts: List<CartVO>) {
        mAdapter.setNewData(carts)
    }

    override fun displayTotal(total: Double) {
        if (total==0.0){
            layoutTotal.visibility = View.INVISIBLE
        }
        else{
            layoutTotal.visibility = View.VISIBLE
            val lblPay = resources.getText(R.string.lbl_pay)
            lblTotal.setText("$lblPay$total")
        }
    }

    override fun navigateToMenu() {
        displayMessage("Menu")
    }

    override fun navigateToNotification() {
        displayMessage("Notification")
    }

    override fun navigateToOrder() {
        displayMessage("Ordered")
    }
}