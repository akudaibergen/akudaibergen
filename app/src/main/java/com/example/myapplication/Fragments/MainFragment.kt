package com.example.myapplication.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.BuildConfig
import com.example.myapplication.adapter.PostAdapter
import com.example.myapplication.R
import com.example.myapplication.api.Client
import com.example.myapplication.api.Service
import com.example.myapplication.model.Movie
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment(), PostAdapter.RecyclerViewItemClick {
    lateinit var recyclerView: RecyclerView
    private var postAdapter: PostAdapter? = null
    lateinit var swipeRefreshLayout: SwipeRefreshLayout

    lateinit var movieList:List<com.example.myapplication.model.Movie>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_main, container, false)

        initViews(view)



        swipeRefreshLayout=view.findViewById(R.id.swipeRefreshLayout)
        swipeRefreshLayout.setOnRefreshListener {
            postAdapter?.clearAll()
            initViews(view)
        }



//        getPosts()

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun itemClick(position: Int, item: Movie) {
        Toast.makeText(view?.context, item.title, Toast.LENGTH_SHORT).show()


    }

    private fun initViews(view:View)
    {
        recyclerView = view.findViewById(R.id.recyclerView)

        movieList=ArrayList<com.example.myapplication.model.Movie>();
        postAdapter = PostAdapter(view?.context, movieList)
        recyclerView.layoutManager = LinearLayoutManager(view?.context)
        recyclerView.adapter = postAdapter
        recyclerView.adapter?.notifyDataSetChanged()
    }

    private fun loadJSON()
    {
        try {
            if (BuildConfig.THE_MOVIE_DB_API_TOKEN.isEmpty()) {
                Toast.makeText(view?.context, "Lala", Toast.LENGTH_SHORT).show()
                return
            }

            var client=Client()
            var apiService=Client.getClient().create(Service::class.java)
            var call=apiService.getPopularMovies(BuildConfig.THE_MOVIE_DB_API_TOKEN)
            call.enqueue(object : Callback<List<com.example.myapplication.model.Movie>> {
                override fun onFailure(call: Call<List<com.example.myapplication.model.Movie>>, t: Throwable) {
                    Log.d("Error", t.message)
                    Toast.makeText(view?.context, "Error", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<List<com.example.myapplication.model.Movie>>,
                    response: Response<List<com.example.myapplication.model.Movie>>
                ) {

                    val movies = response.body()

                    recyclerView.adapter=
                        PostAdapter(view!!.context, movies)
                    if (swipeRefreshLayout.isRefreshing)
                    {
                        swipeRefreshLayout.isRefreshing=false
                    }
                }
            })
        }
        catch(e:Exception){
            Log.d("Error", e.message)
            Toast.makeText(view?.context, "Error", Toast.LENGTH_SHORT).show()

        }

    }
//    @Override
//    public fun onCreate
}

