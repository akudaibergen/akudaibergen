package com.example.myapplication


import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

object RetrofitService {

    const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    fun getMovieApi(): MovieApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
            .build()
        return retrofit.create(MovieApi::class.java)
    }
}

interface MovieApi {

    @GET("posts")
    fun getMovieList(): Call<List<Movie>>

    @GET("posts/{id}")
    fun getMovieById(@Path("id") id: Int): Call<Movie>
}