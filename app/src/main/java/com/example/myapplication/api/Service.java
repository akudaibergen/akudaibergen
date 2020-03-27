package com.example.myapplication.api;

import com.example.myapplication.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {
@GET("movie/popular")
    Call<List<Movie>>  getPopularMovies(@Query("api_key") String apiKey);

@GET("movie/top_rated")
Call<List<Movie>> getTopRatedMovies(@Query("api_key") String apiKey);

@GET("movie/id")
    Call<Movie> getMovieById(@Query("api_key") String apiKey);
}
