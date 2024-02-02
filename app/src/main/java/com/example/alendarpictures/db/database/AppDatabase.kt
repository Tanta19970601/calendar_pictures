package com.example.alendarpictures.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.alendarpictures.db.converters.Converter
import com.example.alendarpictures.db.dao.WikipediaEventsDao
import com.example.alendarpictures.db.entities.WikipediaEventsEntity

@Database(
    entities = [WikipediaEventsEntity::class], version = 1
)

@TypeConverters(Converter::class)

abstract class AppDatabase : RoomDatabase() {

    abstract fun wikipediaEventsDao(): WikipediaEventsDao
}