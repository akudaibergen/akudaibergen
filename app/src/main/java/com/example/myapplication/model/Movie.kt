package com.example.myapplication.model
import android.media.Image
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Movie(
    @SerializedName("moviesList")
    var moviesList: List<Movie>? = null,
    @SerializedName("id")
    val id:Int,
    @SerializedName("title")
    val title :String,
    @SerializedName("body")
    val body:String,
    @SerializedName("genre")
    val genre:String,
    @SerializedName("image")
    val image: String,
    @SerializedName("releaseDate")
    val releaseDate:String,
    @SerializedName("year")
    val year:Int,
    @SerializedName("actors")
    val actors:String
):Serializable