package com.example.myapplication.Fragments


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.MainActivity
import com.example.myapplication.MovieDetailActivity

import com.example.myapplication.R
import com.example.myapplication.adapter.LikedListAdapter
import com.example.myapplication.model.Movie
import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class LikeFragment : Fragment() {
    private var recyclerView: RecyclerView? = null
    private var adapter: LikedListAdapter? = null

    private var listener: LikedListAdapter.ItemClickListener? = null
    private var fragmentLikeListener: LikedListAdapter.FragmentLikeListener? = null


    lateinit var moviesList: MutableList<Movie>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView =
            inflater.inflate(R.layout.fragment_like, container, false) as ViewGroup
        recyclerView = rootView.findViewById(R.id.recyclerView)
        recyclerView?.layoutManager = LinearLayoutManager(rootView?.context)



        listener = object : LikedListAdapter.ItemClickListener{
            override fun itemClick(position: Int, item: Movie) {
                val intent = Intent(activity, MovieDetailActivity::class.java)
                intent.putExtra("news", item)
                startActivity(intent)
            }
        }


        fragmentLikeListener = object : LikedListAdapter.FragmentLikeListener {
            override fun removeItemLike(news: Movie) {
                (activity as MainActivity).removeItemLike(news)
            }
        }
        moviesList = ArrayList<Movie>()
        adapter = LikedListAdapter(moviesList, listener, fragmentLikeListener)
        recyclerView?.adapter = adapter
        return rootView
    }


    fun saveNews(news: Movie) {
        moviesList.add(news)
        recyclerView?.getAdapter()!!.notifyItemInserted(moviesList.size - 1)
    }

    fun removeNews(news: Movie) {
        if (moviesList.indexOf(news) == 0) {
            moviesList.remove(news)
        } else {
            val position = moviesList.indexOf(news)
            moviesList.remove(news)
            recyclerView?.adapter?.notifyItemRemoved(position)
        }
    }

    fun removeLike(news: Movie) {
        val n = moviesList.indexOf(news)
        this.removeNews(news)
        adapter?.notifyItemRemoved(n)
    }



}
