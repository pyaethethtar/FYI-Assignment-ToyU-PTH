package com.example.toyu.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.toyu.R
import com.example.toyu.mvp.presenters.DetailsPresenter
import com.example.toyu.mvp.presenters.impls.DetailsPresenterImpl
import com.example.toyu.mvp.view.DetailsView
import com.example.toyu.data.vos.ToyVO
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.viewpod_details.*

class DetailsActivity : BaseActivity(), DetailsView {

    private lateinit var mPresenter : DetailsPresenter
    private var mToyId : String = ""

    companion object{
        const val TOY_ID_EXTRA = "TOY_ID_EXTRA"
        fun newIntent(context: Context, id: String) : Intent{
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(TOY_ID_EXTRA, id)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        mToyId = intent.getStringExtra(TOY_ID_EXTRA)?:" "
        setUpPresenter()
        setUpListeners()
        mPresenter.onUiReady(mToyId, this)
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProvider(this).get(DetailsPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpListeners(){
        btnBack.setOnClickListener {
            mPresenter.onTapBack()
        }
        btnFav.setOnClickListener {
            mPresenter.onTapFavourite()
        }
        btnAddToCart.setOnClickListener {
            mPresenter.onTapAddToCart(mToyId)
        }
        btnSwap.setOnClickListener {
            mPresenter.onTapSwap(mToyId)
        }

        btnLeft.setOnClickListener {
            displayMessage("Tapped Left")
        }
        btnRight.setOnClickListener {
            displayMessage("Tapped Right")
        }
    }

    override fun displayToyDetails(toy: ToyVO) {
        Glide.with(this).load(toy.imageList.first().imageUrl).into(ivToy)
        tvPrice.text = "$${toy.price}"
        tvToyType.text = toy.toyCategory
        tvToyName.text = toy.toyName
        ratingbar.progress = toy.rating.toInt()
        tvRate.text = toy.rating.toString()
        tvDescription.text = toy.description
        toy.imageList.forEach {
            //binding colors
        }
        Glide.with(this).load(toy.owner.profileImage).into(ivOwner)
        tvOwner.text = toy.owner.userName

        if (toy.isFavorite){
            btnFav.setBackgroundDrawable(resources.getDrawable(R.drawable.favorite_selected))
        }
        else{
            btnFav.setBackgroundDrawable(resources.getDrawable(R.drawable.favorite_unselected))
        }
    }

    override fun navigateToBack() {
        this.finish()
    }

    override fun navigateToCart() {
        displayMessage("Added to Cart")
    }

    override fun navigateToSwap(id: String) {
        displayMessage("Navigate To Swap")
    }
}