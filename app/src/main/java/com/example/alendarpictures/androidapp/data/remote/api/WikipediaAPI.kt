package com.example.alendarpictures.androidapp.data.remote.api

import com.example.alendarpictures.androidapp.models.WikipediaModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WikipediaAPI {
    @GET("{language}/{onthisday}/{type}/{MM}/{DD}")
    suspend fun getEvent(
        @Path(value = "language") language: String = "en",
        @Path(value = "onthisday") onthisday: String = "onthisday",
        @Path(value = "type") type: String,
        @Path(value = "MM") mm: String,
        @Path(value = "DD") dd: String
    ): Response<WikipediaModel>
}