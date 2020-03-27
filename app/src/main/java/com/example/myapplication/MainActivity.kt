package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.Fragments.LikeFragment
import com.example.myapplication.Fragments.MainFragment

import com.example.myapplication.ViewPager.CustomPagerAdapter
import com.example.myapplication.adapter.LikedListAdapter
import com.example.myapplication.adapter.MoviesListAdapter
import com.example.myapplication.model.Movie
import com.google.android.material.bottomnavigation.BottomNavigationView

import java.util.ArrayList

class MainActivity : AppCompatActivity(), MoviesListAdapter.FragmentButtonListener,LikedListAdapter.FragmentLikeListener {
    lateinit internal var pager: ViewPager
    private var toolbar: Toolbar? = null
    //private var prevMenuItem: MenuItem? = null
    private var bottomNavigationView: BottomNavigationView? = null
    internal var list: MutableList<Fragment> = ArrayList()
    private var prevMenuItem: MenuItem? = null
    internal var pagefragment = MainFragment()
    internal var fragment= LikeFragment()


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
        val pagerAdapter = CustomPagerAdapter(
            supportFragmentManager,
            list
        )//adapter for pager
        pager.setAdapter(pagerAdapter)


        bottomNavigationView?.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.Main -> {
                    pager.setCurrentItem(0, false)
//                    bottomNavigationView.menu.findItem(R.id.navigation_home)
//                        .setIcon(R.drawable.ic_home)
//                    bottomNavigationView.menu.findItem(R.id.navigation_likes)
//                        .setIcon(R.drawable.ic_heart)
                }
                R.id.Likes -> {
                   pager.setCurrentItem(1, false)
//                    item.setIcon(R.drawable.ic_favorite)
                }
                R.id.Profile -> {
                   pager.setCurrentItem(1, false)
//                    item.setIcon(R.drawable.ic_favorite)
                }
            }
            false
        }


        pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                if (prevMenuItem != null)
                    prevMenuItem?.setChecked(false)
                else
                    bottomNavigationView?.menu?.getItem(0)?.isChecked = false

                bottomNavigationView?.menu?.getItem(position)?.isChecked = true
                prevMenuItem = bottomNavigationView?.menu?.getItem(position)
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

    }
    override fun myClick(news: Movie, option: Int) {

        if (option == 1)
            fragment.saveNews(news)
        else
            fragment.removeNews(news)
    }


    override fun removeItemLike(movies: Movie) {
      //  pagefragment.removeLike(movies)
        fragment.removeLike(movies)
    }

    }


