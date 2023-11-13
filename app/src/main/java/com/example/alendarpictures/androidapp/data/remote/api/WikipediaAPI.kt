package com.example.alendarpictures.androidapp.data.remote.api

import com.example.alendarpictures.androidapp.models.WikipediaModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WikipediaAPI {
    @GET("wikipedia")
    suspend fun getEvent(
        @Query(value = "language") language: String = "en",
        @Query(value = "onthisday") onthisday: String = "onthisday",
        @Query(value = "type") type: String = "events",
        @Query(value = "MM") mm: String,
        @Query(value = "DD") dd: String
    ): Response<WikipediaModel>
}