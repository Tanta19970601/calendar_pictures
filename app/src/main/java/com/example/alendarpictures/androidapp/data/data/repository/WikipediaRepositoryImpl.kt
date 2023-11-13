package com.example.alendarpictures.androidapp.data.data.repository

import com.example.alendarpictures.androidapp.data.remote.WikipediaRepository
import com.example.alendarpictures.androidapp.data.remote.api.WikipediaAPI
import com.example.alendarpictures.androidapp.models.WikipediaModel
import retrofit2.Response
import java.time.LocalDate
import javax.inject.Inject

class WikipediaRepositoryImpl @Inject constructor(private val wikipediaAPI: WikipediaAPI) :
    WikipediaRepository {


    override suspend fun getWikipediaEvents(date: LocalDate): Response<WikipediaModel> {
        return wikipediaAPI.getEvent(mm = date.month.toString(), dd = date.dayOfMonth.toString())
    }

    override suspend fun getPicture(string: String) {}
}