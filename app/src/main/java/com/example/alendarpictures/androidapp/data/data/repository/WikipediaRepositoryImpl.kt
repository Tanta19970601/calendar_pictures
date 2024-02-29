package com.example.alendarpictures.androidapp.data.data.repository

import com.example.alendarpictures.androidapp.data.remote.WikipediaRepository
import com.example.alendarpictures.androidapp.data.remote.api.WikipediaAPI
import com.example.alendarpictures.androidapp.models.Birth
import com.example.alendarpictures.androidapp.models.Death
import com.example.alendarpictures.androidapp.models.Event
import com.example.alendarpictures.db.dao.WikipediaEventsDao
import com.example.alendarpictures.db.entities.WikipediaEventsEntity
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate
import javax.inject.Inject

class WikipediaRepositoryImpl @Inject constructor(
    private val wikipediaAPI: WikipediaAPI,
    private val wikipediaEventsDao: WikipediaEventsDao
) : WikipediaRepository {


    override suspend fun getWikipediaEvent(
        monthValue: String,
        dayOfMonth: String,
        typeEvent: String,
        typeLanguage: String
    ): Flow<List<WikipediaEventsEntity>> {
        val eventsW =
            wikipediaAPI.getEvent(
                language = typeLanguage,
                mm = monthValue,
                dd = dayOfMonth,
                type = typeEvent
            )
        eventsW.body()?.births?.forEach { event ->
            wikipediaEventsDao.insert(
                WikipediaEventsEntity(
                    nameEvent = event.text,
                    language = typeLanguage,
                    dayEvent = dayOfMonth,
                    monthEvent = monthValue,
                    type = typeEvent
                )
            )
        }
        eventsW.body()?.deaths ?.forEach { event ->
            wikipediaEventsDao.insert(
                WikipediaEventsEntity(
                    nameEvent = event.text,
                    language = typeLanguage,
                    dayEvent = dayOfMonth,
                    monthEvent = monthValue,
                    type = typeEvent
                )
            )
        }
        eventsW.body()?.holidays?.forEach { event ->
            wikipediaEventsDao.insert(
                WikipediaEventsEntity(
                    nameEvent = event.text,
                    language = typeLanguage,
                    dayEvent = dayOfMonth,
                    monthEvent = monthValue,
                    type = typeEvent
                )
            )
        }
        eventsW.body()?.events?.forEach { event ->
            wikipediaEventsDao.insert(
                WikipediaEventsEntity(
                    nameEvent = event.text,
                    language = typeLanguage,
                    dayEvent = dayOfMonth,
                    monthEvent = monthValue,
                    type = typeEvent
                )
            )
        }
        eventsW.body()?.selected?.forEach { event ->
            wikipediaEventsDao.insert(
                WikipediaEventsEntity(
                    nameEvent = event.text,
                    language = typeLanguage,
                    dayEvent = dayOfMonth,
                    monthEvent = monthValue,
                    type = typeEvent
                )
            )
        }
        return wikipediaEventsDao.getAll()
    }


//    override suspend fun getWikipediaEvents(): Flow<List<WikipediaEventsEntity>> {
//        return wikipediaEventsDao.getAll()
//    }

    override suspend fun getNameEvent(): List<WikipediaEventsEntity> {
        return wikipediaEventsDao.getListEvent()
    }


    override suspend fun saveWikipediaEvents(date: LocalDate): WikipediaEventsEntity {
        return WikipediaEventsEntity()
    }


    override suspend fun getPicture(string: String) {}

//    override suspend fun updateWikipediaEventsEntity(): WikipediaEventsEntity {
//    }
}