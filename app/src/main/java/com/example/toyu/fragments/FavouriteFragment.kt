package com.example.toyu.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.toyu.R
import com.example.toyu.activities.DetailsActivity
import com.example.toyu.data.vos.ToyVO
import com.example.toyu.mvp.presenters.FavouritePresenter
import com.example.toyu.mvp.presenters.impls.FavouritePresenterImpl
import com.example.toyu.mvp.view.FavouriteView
import com.example.toyu.viewpods.EmptyViewPod
import com.example.toyu.viewpods.ToysViewPod
import kotlinx.android.synthetic.main.fragment_favourite.*

class FavouriteFragment : BaseFragment(), FavouriteView {

    private lateinit var mContext : Context
    private lateinit var mPresenter : FavouritePresenter
    private lateinit var mEmptyViewPod : EmptyViewPod
    private lateinit var mToysViewPod: ToysViewPod

    companion object{
        fun newInstance() : FavouriteFragment{
            return FavouriteFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favourite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenterAndViewPod()
        mPresenter.onUiReady(this)
    }

    private fun setUpPresenterAndViewPod(){
        mPresenter = ViewModelProvider(this).get(FavouritePresenterImpl::class.java)
        mPresenter.initPresenter(this)

        mEmptyViewPod = vpEmpty as EmptyViewPod
        mToysViewPod = vpToys as ToysViewPod
        mToysViewPod.setUpAdapter(mPresenter)
    }

    override fun displayEmpty() {
        vpEmpty.visibility = View.VISIBLE
        vpToys.visibility = View.GONE
    }

    override fun displayFavouriteToys(toys: List<ToyVO>) {
        vpEmpty.visibility = View.GONE
        vpToys.visibility = View.VISIBLE

        mToysViewPod.displayToys(toys)
    }

    override fun navigateToDetails(id: String) {
        startActivity(DetailsActivity.newIntent(mContext, id))
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
}