package com.example.toyu.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.toyu.R
import com.example.toyu.activities.DetailsActivity
import com.example.toyu.activities.FilterActivity
import com.example.toyu.activities.SearchActivity
import com.example.toyu.adapters.PromotionAdapter
import com.example.toyu.adapters.ToysAdapter
import com.example.toyu.mvp.presenters.HomePresenter
import com.example.toyu.mvp.presenters.impls.HomePresenterImpl
import com.example.toyu.mvp.view.HomeView
import com.example.toyu.data.vos.ToyVO
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.btnMenu

class HomeFragment : BaseFragment(), HomeView {

    companion object{
        fun newInstance() : HomeFragment{
            return HomeFragment()
        }
    }

    private lateinit var mContext: Context
    private lateinit var mAdapter: ToysAdapter
    private lateinit var promotionAdapter: PromotionAdapter
    private lateinit var mPresenter: HomePresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()
        setUpAdapter()
        setUpListeners()
        mPresenter.onUiReady(this)
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProvider(this).get(HomePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpAdapter(){
        mAdapter = ToysAdapter(mPresenter)
        rvToys.adapter = mAdapter
        rvToys.setHasFixedSize(false)
        rvToys.layoutManager = StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL)

        promotionAdapter = PromotionAdapter()
        rvPromotions.adapter = promotionAdapter
        rvPromotions.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setUpListeners(){
        btnSearch.setOnClickListener {
            mPresenter.onTapSearch(etSearch.text.toString())
        }
        btnFilter.setOnClickListener {
            mPresenter.onTapFilter()
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

    override fun displayToys(toys: List<ToyVO>) {
        mAdapter.setNewData(toys)
    }

    override fun displayPromotionToys(toys: List<ToyVO>) {
        promotionAdapter.setNewData(toys)
    }

    override fun navigateToDetails(id: String) {
        startActivity(DetailsActivity.newIntent(mContext, id))
    }

    override fun navigateToFilter() {
        startActivity(FilterActivity.newIntent(mContext))
    }

    override fun navigateToSearch(keyword: String?) {
        etSearch.text?.clear()
        startActivity(SearchActivity.newIntent(mContext, keyword?:""))
    }

    override fun navigateToMenu() {
        displayMessage("Menu")
    }

    override fun navigateToNotification() {
        displayMessage("Notification")
    }
}