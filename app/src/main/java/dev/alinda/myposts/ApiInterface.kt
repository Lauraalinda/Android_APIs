package dev.alinda.myposts

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/posts")
    fun getPosts(): Call<List<Post>>

    @GET("/comments")
    fun getComments(): Call<List<Comment>>

    @GET("/posts/{id}")
    fun getPostById(@Path("id") postId: Int): Call<Post> //we use it wen we are going to create an interface to click to get comments
}

//api client makes requests to the server and recieves reponses