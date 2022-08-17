package com.example.toyu.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.toyu.R
import com.example.toyu.mvp.presenters.FilterPresenter
import com.example.toyu.mvp.presenters.impls.FilterPresenterImpl
import com.example.toyu.mvp.view.FilterView
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.activity_filter.*

class FilterActivity : BaseActivity(), FilterView {
    
    private lateinit var mPresenter: FilterPresenter
    private var mToyCategory : String = ""
    private var mAgeCategory : String = ""

    companion object{
        fun newIntent(context: Context) : Intent{
            return Intent(context, FilterActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)
        setSupportActionBar(toolbar)
        
        setUpPresenter()
        setUpListeners()
    }
    
    private fun setUpPresenter(){
        mPresenter = ViewModelProvider(this).get(FilterPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }
    
    private fun setUpListeners(){
        btnBack.setOnClickListener { 
            mPresenter.onTapBack()
        }
        cgToyCategories.setOnCheckedStateChangeListener { group, checkedIds ->
            var chip = findViewById<Chip>(group.checkedChipId)
            if (chip!=null){
                mToyCategory = chip.text.toString()
//                mPresenter.onChooseToyCategory(mToyCategory)
            }
        }
        cvUner3.setOnClickListener {
            selectUnder3()
        }
        cvUner7.setOnClickListener {
            selectUnder7()
        }
        cvUner14.setOnClickListener {
            selectUnder14()
        }
        btnSetDefault.setOnClickListener {
            mPresenter.onTapSetDefault()
        }
        btnApplyFilter.setOnClickListener {
            mPresenter.onTapApplyFilter(mToyCategory, mAgeCategory, sbPricing.progress, cbPricing.isChecked)
        }
    }

    override fun navigateToBack() {
        this.finish()
    }

    override fun showSelectedToyCategory(toyCategory: String) {
        displayMessage(toyCategory)
    }

    override fun showSelectedAgeCategory(ageCategory: String) {
        displayMessage(ageCategory)
    }

    override fun clearAll() {
        mToyCategory = ""
        mAgeCategory = ""
        cgToyCategories.clearCheck()
        clearAgeCategories()
        sbPricing.progress = 0
        cbPricing.isChecked = false
    }

    override fun showFilterResult(toyCategory: String, ageCategory: String, price: Int, isSetAverage: Boolean) {
        displayMessage("$toyCategory, $ageCategory, $price, $isSetAverage")
    }

    private fun clearAgeCategories(){
        cvUner3.setCardBackgroundColor(resources.getColor(R.color.white))
        lblUnder3.setTextColor(resources.getColor(R.color.colorSecondaryLight))
        tvUnder3.setTextColor(resources.getColor(R.color.colorSecondary))

        cvUner7.setCardBackgroundColor(resources.getColor(R.color.white))
        lblUnder7.setTextColor(resources.getColor(R.color.colorSecondaryLight))
        tvUnder7.setTextColor(resources.getColor(R.color.colorSecondary))

        cvUner14.setCardBackgroundColor(resources.getColor(R.color.white))
        lblUnder14.setTextColor(resources.getColor(R.color.colorSecondaryLight))
        tvUnder14.setTextColor(resources.getColor(R.color.colorSecondary))
    }

    private fun selectUnder3(){
        mAgeCategory = "Under 03"
        cvUner3.setCardBackgroundColor(resources.getColor(R.color.colorSecondary))
        lblUnder3.setTextColor(resources.getColor(R.color.white))
        tvUnder3.setTextColor(resources.getColor(R.color.white))

        cvUner7.setCardBackgroundColor(resources.getColor(R.color.white))
        lblUnder7.setTextColor(resources.getColor(R.color.colorSecondaryLight))
        tvUnder7.setTextColor(resources.getColor(R.color.colorSecondary))

        cvUner14.setCardBackgroundColor(resources.getColor(R.color.white))
        lblUnder14.setTextColor(resources.getColor(R.color.colorSecondaryLight))
        tvUnder14.setTextColor(resources.getColor(R.color.colorSecondary))
    }

    private fun selectUnder7(){
        mAgeCategory = "Under 07"
        cvUner7.setCardBackgroundColor(resources.getColor(R.color.colorSecondary))
        lblUnder7.setTextColor(resources.getColor(R.color.white))
        tvUnder7.setTextColor(resources.getColor(R.color.white))

        cvUner3.setCardBackgroundColor(resources.getColor(R.color.white))
        lblUnder3.setTextColor(resources.getColor(R.color.colorSecondaryLight))
        tvUnder3.setTextColor(resources.getColor(R.color.colorSecondary))

        cvUner14.setCardBackgroundColor(resources.getColor(R.color.white))
        lblUnder14.setTextColor(resources.getColor(R.color.colorSecondaryLight))
        tvUnder14.setTextColor(resources.getColor(R.color.colorSecondary))
    }

    private fun selectUnder14(){
        mAgeCategory = "Under 14"
        cvUner14.setCardBackgroundColor(resources.getColor(R.color.colorSecondary))
        lblUnder14.setTextColor(resources.getColor(R.color.white))
        tvUnder14.setTextColor(resources.getColor(R.color.white))

        cvUner7.setCardBackgroundColor(resources.getColor(R.color.white))
        lblUnder7.setTextColor(resources.getColor(R.color.colorSecondaryLight))
        tvUnder7.setTextColor(resources.getColor(R.color.colorSecondary))

        cvUner3.setCardBackgroundColor(resources.getColor(R.color.white))
        lblUnder3.setTextColor(resources.getColor(R.color.colorSecondaryLight))
        tvUnder3.setTextColor(resources.getColor(R.color.colorSecondary))
    }


}