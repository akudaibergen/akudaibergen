package com.example.myapplication
import android.media.Image
import com.google.gson.annotations.SerializedName

data class Movie(
  val id:Int,
  val title :String,
  val body:String,
  val genre:String,
  val image: String,
  val releaseDate:String,
  val year:Int,
  val actors:String
)