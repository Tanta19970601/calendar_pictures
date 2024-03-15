package com.example.alendarpictures.androidapp.data.data.repository

import com.example.alendarpictures.androidapp.data.remote.EventsRepository
import com.example.alendarpictures.androidapp.data.remote.WikipediaRepository
import com.example.alendarpictures.androidapp.data.remote.api.WikipediaAPI
import com.example.alendarpictures.db.dao.EventDao
import com.example.alendarpictures.db.entities.EventEntity
import com.example.alendarpictures.db.entities.WikipediaEventsEntity
import javax.inject.Inject
import javax.inject.Provider

class EventsRepositoryImpl @Inject constructor(
    private val eventDao: EventDao
) : EventsRepository {

    override suspend fun setOneEvent() {
        return
    }

    override suspend fun getOne(id: Long): EventEntity {
        val title = eventDao.getNameTitle(id = id)
        val eventEntity = EventEntity(id = id, titleName = title.nameEvent)
        eventDao.insert(eventEntity)
        return eventEntity
    }
}