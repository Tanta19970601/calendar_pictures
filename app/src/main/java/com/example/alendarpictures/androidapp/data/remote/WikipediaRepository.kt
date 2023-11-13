package com.example.alendarpictures.androidapp.data.remote

import com.example.alendarpictures.androidapp.models.WikipediaModel
import retrofit2.Response
import java.time.LocalDate

interface WikipediaRepository {

    suspend fun getWikipediaEvents(date: LocalDate): Response<WikipediaModel>

    suspend fun getPicture(string: String)
}