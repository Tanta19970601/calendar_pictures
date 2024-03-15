package com.example.alendarpictures.androidapp.data.remote

import com.example.alendarpictures.db.entities.EventEntity
import com.example.alendarpictures.db.entities.WikipediaEventsEntity

interface EventsRepository {

    suspend fun setOneEvent() {}

    suspend fun getOne(id: Long): EventEntity
}