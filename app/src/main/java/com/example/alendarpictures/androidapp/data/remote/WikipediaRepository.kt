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
    ): WikipediaEventsEntity?

    suspend fun getWikipediaEvents(): Flow<List<WikipediaEventsEntity>>

    suspend fun getNameEvent(): WikipediaEventsEntity?

    suspend fun saveWikipediaEvents(date: LocalDate): WikipediaEventsEntity
    suspend fun getPicture(string: String)

//    suspend fun updateWikipediaEventsEntity(): WikipediaEventsEntity
}