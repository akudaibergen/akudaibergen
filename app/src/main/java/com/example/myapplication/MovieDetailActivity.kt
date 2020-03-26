package com.example.myapplication

import android.media.Image
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body


class MovieDetailActivity : AppCompatActivity() {
    private lateinit var tvTitle: TextView
    private lateinit var tvGenre: TextView
    private lateinit var tvReleaseDate: TextView
    private lateinit var tvImage: ImageView
    private lateinit var tvBody: TextView
    private lateinit var tvYearOfMovie: TextView
    private lateinit var tvActors: TextView
    private lateinit var progressBar: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        tvTitle = findViewById(R.id.tvTitle)
        tvGenre = findViewById(R.id.genreOfMovie)
        tvReleaseDate = findViewById(R.id.releaseDateOfMovie)
        tvImage = findViewById(R.id.imageOfMovie)
        tvBody = findViewById(R.id.bodyOfMovie)
        tvYearOfMovie = findViewById(R.id.yearOfMovie)
        tvActors = findViewById(R.id.actorsOfMovie)
        progressBar = findViewById(R.id.progressBar)

        val movieId = intent.getIntExtra("movie_id", 1)
        getMovie(id = movieId)
    }
    private fun getMovie(id:Int) {
        RetrofitService.getMovieApi().getMovieById(id).enqueue(object: Callback<Movie>{
            override fun onFailure(call: Call<Movie>, t: Throwable) {
                progressBar.visibility = View.GONE
            }

            override fun onResponse(call:Call<Movie>, response: Response<Movie>){
                progressBar.visibility = View.GONE
                val movie = response.body()
                if(movie != null){
                    tvTitle = movie.title
                    tvBody = movie.body

                }
            }
        })
    }



}