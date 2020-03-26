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

class MainActivity : AppCompatActivity(), PostAdapter.RecyclerViewItemClick {

    lateinit var recyclerView: RecyclerView

//    to check branch hafjhfajhafjf dfjkadsfjdsfakjh

    private var postAdapter: PostAdapter? = null
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

        postAdapter = PostAdapter(itemClickListener = this)
        recyclerView.adapter = postAdapter
        bottomNavigationView = findViewById(R.id.bottom)

        getPosts()
    }

    override fun itemClick(position: Int, item: Post) {
        Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()


    }

    private fun getPosts() {
        swipeRefreshLayout.isRefreshing=true
        RetrofitService.getPostApi().getPostList().enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
        swipeRefreshLayout.isRefreshing=false
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
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

