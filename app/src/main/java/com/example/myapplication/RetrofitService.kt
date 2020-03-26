package com.example.myapplication
//
//
//import com.google.gson.Gson
//
//import retrofit2.Call
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.http.GET
//import retrofit2.http.Query
//
//object RetrofitService {
//
//    const val BASE_URL = "https://api.themoviedb.org/3/"
//
//    fun getPostApi(): PostApi {
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        return retrofit.create(PostApi::class.java)
//    }
//}
//
//interface PostApi {
//
//    @GET("movie/popular")
//    Call<MovieResponse> getPopularMovies()
//
//}