package com.example.alendarpictures.androidapp.data.data.repository

import com.example.alendarpictures.androidapp.data.remote.WikipediaRepository
import com.example.alendarpictures.androidapp.data.remote.api.WikipediaAPI
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
        type: String
    ): WikipediaEventsEntity? {
        val eventsW =
            wikipediaAPI.getEvent(
                mm = monthValue,
                dd = dayOfMonth,
                type = type
            )
        wikipediaEventsDao.insert(
            WikipediaEventsEntity(
                    nameEvent = when (type.lowercase()) {
                    "births" -> eventsW.body()?.births?.get(1)?.text.orEmpty()
                    "deaths" -> eventsW.body()?.deaths?.get(1)?.text.orEmpty()
                    "events" -> eventsW.body()?.events?.get(1)?.text.orEmpty()
                    "holidays" -> eventsW.body()?.holidays?.get(1)?.text.orEmpty()
                    else -> eventsW.body()?.selected?.get(1)?.text.orEmpty()
                },
                language = "en",
                dayEvent = dayOfMonth,
                monthEvent = monthValue,
                type = type
            )
        )
        return wikipediaEventsDao.getNameEvent()
    }

    override suspend fun getWikipediaEvents(): Flow<List<WikipediaEventsEntity>> {
        return wikipediaEventsDao.getAll()
    }

    override suspend fun getNameEvent(): WikipediaEventsEntity? {
        return wikipediaEventsDao.getNameEvent()
    }


    override suspend fun saveWikipediaEvents(date: LocalDate): WikipediaEventsEntity {
        return WikipediaEventsEntity()
    }

    override suspend fun getPicture(string: String) {}

//    override suspend fun updateWikipediaEventsEntity(): WikipediaEventsEntity {
//    }
}