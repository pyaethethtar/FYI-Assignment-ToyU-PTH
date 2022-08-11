package com.example.toyu.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.toyu.R
import com.example.toyu.adapters.ToysAdapter
import com.example.toyu.data.vos.ToyVO
import com.example.toyu.mvp.presenters.SearchPresenter
import com.example.toyu.mvp.presenters.impls.SearchPresenterImpl
import com.example.toyu.mvp.view.SearchView
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : BaseActivity(), SearchView {

    private lateinit var mPresenter: SearchPresenter
    private lateinit var mAdapter : ToysAdapter
    private var mKeyword: String = ""

    companion object{
        const val KEYWORD_EXTRA = "KEYWORD_EXTRA"
        fun newIntent(context: Context, keyword: String) : Intent{
            val intent = Intent(context, SearchActivity::class.java)
            intent.putExtra(KEYWORD_EXTRA, keyword)
            return intent
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        setSupportActionBar(toolbar)

        mKeyword = intent.getStringExtra(KEYWORD_EXTRA)?:""
        setUpPresenter()
        setUpAdapter()
        setUpListeners()
        mPresenter.onUiReady(mKeyword, this)
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProvider(this).get(SearchPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpAdapter(){
        mAdapter = ToysAdapter(mPresenter)
        rvSearch.adapter = mAdapter
        rvSearch.layoutManager = StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL)
    }

    private fun setUpListeners(){
        etSearch.setText(mKeyword)

        btnBack.setOnClickListener {
            mPresenter.onTapBack()
        }
        btnSearch.setOnClickListener {
            mPresenter.onTapSearch(etSearch.text.toString())
        }
    }

    override fun displaySearchResult(toys: List<ToyVO>) {
        mAdapter.setNewData(toys)
    }

    override fun displayResultCount(count: Int) {
        if (count==0){
            tvResult.visibility= View.INVISIBLE
        }
        else{
            tvResult.visibility = View.VISIBLE
            tvResult.setText("$count result found")
        }
    }

    override fun navigateToBack() {
        this.finish()
    }

    override fun navigateToDetails(id: String) {
        startActivity(DetailsActivity.newIntent(this, id))
    }
}