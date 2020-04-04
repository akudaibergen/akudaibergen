package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.bottomnavigation.BottomNavigationView

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), MovieAdapter.RecyclerViewItemClick {

    lateinit var recyclerView: RecyclerView

    private var postAdapter: MovieAdapter? = null
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    lateinit var  bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        swipeRefreshLayout=findViewById(R.id.swipeRefreshLayout)
        swipeRefreshLayout.setOnRefreshListener {
            postAdapter?.clearAll()
            getPosts()
        }

        postAdapter = MovieAdapter(itemClickListener = this)
        recyclerView.adapter = postAdapter
        bottomNavigationView = findViewById(R.id.bottom)

        getPosts()
    }

    override fun itemClick(position: Int, item: Movie) {
        Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()


    }

    private fun getPosts() {
        swipeRefreshLayout.isRefreshing=true
        RetrofitService.getMovieApi().getMovieList().enqueue(object : Callback<List<Movie>> {
            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
        swipeRefreshLayout.isRefreshing=false
            }

            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                Log.d("My_post_list", response.body().toString())
                if(response.isSuccessful){
                    val list = response.body()
                    postAdapter?.list = list
                    postAdapter?.notifyDataSetChanged()
                }
                swipeRefreshLayout.isRefreshing=false
            }
        })
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
}

