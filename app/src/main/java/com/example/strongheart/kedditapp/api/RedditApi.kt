package com.example.strongheart.kedditapp.api

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

interface RedditApi {
    @GET("/top.json")
    fun getTop(@Query("after") after: String,
               @Query("limit") limit: String) : Call<RedditNewsResponse>
}