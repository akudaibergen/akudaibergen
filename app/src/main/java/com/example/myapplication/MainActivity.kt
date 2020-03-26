package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class MainActivity : AppCompatActivity(){
    lateinit internal var pager: ViewPager
    private var toolbar: Toolbar? = null
    //private var prevMenuItem: MenuItem? = null
    private var bottomNavigationView: BottomNavigationView? = null
    internal var list: MutableList<Fragment> = ArrayList()


    internal var pagefragment = MainFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bottomNavigationView = findViewById(R.id.bottom)

        toolbar = findViewById(R.id.toolbar)//toolbar
        setSupportActionBar(toolbar)
//        supportActionBar!!.setDisplayShowTitleEnabled(true)
//        supportActionBar!!.setDisplayShowHomeEnabled(true)

        list.add(pagefragment)//adding fragments to list
        //list.add(fragment)
        pager = findViewById(R.id.viewPager)//find pager
        //pager.setSwipeable(false)
        val pagerAdapter = CustomPagerAdapter(supportFragmentManager, list)//adapter for pager
        pager.setAdapter(pagerAdapter)


//        this.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.main -> {
//                    pager.setCurrentItem(0, false)
////                    bottomNavigationView.menu.findItem(R.id.navigation_home)
////                        .setIcon(R.drawable.ic_home)
////                    bottomNavigationView.menu.findItem(R.id.navigation_likes)
////                        .setIcon(R.drawable.ic_heart)
//                }
//                R.id.Likes -> {
////                    pager.setCurrentItem(1, false)
////                    item.setIcon(R.drawable.ic_favorite)
//                }
//                R.id.Profile -> {
////                    pager.setCurrentItem(1, false)
////                    item.setIcon(R.drawable.ic_favorite)
//                }
//            }
//            false
//        }
//
//
//        pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
//            override fun onPageScrolled(
//                position: Int,
//                positionOffset: Float,
//                positionOffsetPixels: Int
//            ) {
//
//            }
//
//            override fun onPageSelected(position: Int) {
//                if (prevMenuItem != null)
//                    prevMenuItem.setChecked(false)
//                else
//                    bottomNavigationView.menu.getItem(0).isChecked = false
//
//                bottomNavigationView.menu.getItem(position).isChecked = true
//                prevMenuItem = bottomNavigationView.menu.getItem(position)
//            }
//
//            override fun onPageScrollStateChanged(state: Int) {
//
//            }
//        })


    }





    }



//    private fun getPost2() {
//        uiScope.launch {
//            val list = withContext(Dispatchers.IO) {
//                RetrofitService.getPostApi().getPostCoroutine()
//            }.await()
//            postAdapter?.list = list
//            postAdapter?.notifyDataSetChanged()
//        }
//    }


