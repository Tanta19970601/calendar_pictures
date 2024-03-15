package com.example.alendarpictures.androidapp.data.remote

import com.example.alendarpictures.db.entities.WikipediaEventsEntity
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface WikipediaRepository {

    suspend fun getWikipediaEvent(
        monthValue: String,
        dayOfMonth: String,
        typeEvent: String,
        typeLanguage: String
    )

    suspend fun getNameEventList(
        monthValue: String,
        dayOfMonth: String,
        typeEvent: String,
        typeLanguage: String
    ): List<WikipediaEventsEntity>
}