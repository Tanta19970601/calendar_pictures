package com.example.alendarpictures.androidapp.data.remote

interface EventsRepository {

    suspend fun getEvents(
        monthValue: String,
        dayOfMonth: String,
        typeEvent: String,
        typeLanguage: String
    )
}