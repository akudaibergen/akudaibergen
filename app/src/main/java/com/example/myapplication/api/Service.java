package com.example.myapplication.api;

import com.example.myapplication.model.Movie;
import com.example.myapplication.model.MovieResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {
@GET("movie/popular")
    Call<List<Movie>>  getPopularMovies(@Query("api_key") String apiKey);

@GET("movie/top_rated")
Call<List<Movie>> getTopRatedMovies(@Query("api_key") String apiKey);
}
