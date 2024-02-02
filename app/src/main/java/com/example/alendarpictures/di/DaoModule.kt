package com.example.alendarpictures.di

import com.example.alendarpictures.db.dao.WikipediaEventsDao
import com.example.alendarpictures.db.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    @Singleton
    fun provideWikipediaEventsDao(db: AppDatabase): WikipediaEventsDao {
        return db.wikipediaEventsDao()
    }
}