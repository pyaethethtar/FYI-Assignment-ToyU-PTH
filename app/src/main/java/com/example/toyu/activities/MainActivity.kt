package com.example.toyu.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.toyu.R
import com.example.toyu.fragments.CartFragment
import com.example.toyu.fragments.FavouriteFragment
import com.example.toyu.fragments.HomeFragment
import com.example.toyu.fragments.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpNavigation()
    }

    private fun setUpNavigation(){
        openFragment(HomeFragment.newInstance())

        btmNavi.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menuHome -> openFragment(HomeFragment.newInstance())
                R.id.menuFav -> openFragment(FavouriteFragment.newInstance())
                R.id.menuCart -> openFragment(CartFragment.newInstance())
                R.id.menuProfile -> openFragment(ProfileFragment.newInstance())
                else -> return@setOnItemSelectedListener false
            }
            true
        }
    }

    private fun openFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit()
    }
}