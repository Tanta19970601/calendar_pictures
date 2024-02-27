package com.example.alendarpictures.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.alendarpictures.db.converters.Converter
import com.example.alendarpictures.db.dao.EventDao
import com.example.alendarpictures.db.dao.WikipediaEventsDao
import com.example.alendarpictures.db.entities.WikipediaEventsEntity
import com.example.alendarpictures.db.entities.EventEntity

@Database(
    entities = [WikipediaEventsEntity::class, EventEntity::class], version = 1
)

@TypeConverters(Converter::class)

abstract class AppDatabase : RoomDatabase() {

    abstract fun wikipediaEventsDao(): WikipediaEventsDao
    abstract fun eventDao(): EventDao
}