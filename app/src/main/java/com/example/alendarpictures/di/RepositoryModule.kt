package com.example.alendarpictures.di

import com.example.alendarpictures.androidapp.data.data.repository.EventsRepositoryImpl
import com.example.alendarpictures.androidapp.data.data.repository.WikipediaRepositoryImpl
import com.example.alendarpictures.androidapp.data.remote.EventsRepository
import com.example.alendarpictures.androidapp.data.remote.WikipediaRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@OptIn(ExperimentalCoroutinesApi::class)
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWikipediaRepository(
        wikipediaRepositoryImpl: WikipediaRepositoryImpl
    ): WikipediaRepository

    @Binds
    @Singleton
    abstract fun bindEventsRepository(
        eventsRepositoryImpl: EventsRepositoryImpl
    ): EventsRepository
}
