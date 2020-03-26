package com.example.myapplication

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Post(
    @SerializedName("id")
    val id: Int,
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String)