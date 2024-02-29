package com.example.alendarpictures.androidapp.data.data.repository

import com.example.alendarpictures.androidapp.data.remote.EventsRepository
import com.example.alendarpictures.androidapp.data.remote.WikipediaRepository
import com.example.alendarpictures.androidapp.data.remote.api.WikipediaAPI
import com.example.alendarpictures.db.dao.EventDao
import com.example.alendarpictures.db.entities.EventEntity

class EventsRepositoryImpl(
    private val wikipediaAPI: WikipediaAPI,
    private val eventDao: EventDao,
    private val wikipediaRepository: WikipediaRepository
) : EventsRepository {
//    override suspend fun getEvents(
//        monthValue: String,
//        dayOfMonth: String,
//        typeEvent: String,
//        typeLanguage: String
//    ): EventEntity? {
//        eventDao.insert(
//            EventEntity(
//                titleName = typeEvent,
//            )
//        )
//        return eventDao.e
//    }


}