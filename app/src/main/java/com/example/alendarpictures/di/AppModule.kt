package com.example.alendarpictures.di

import android.app.Application
import com.example.alendarpictures.androidapp.data.remote.api.WikipediaAPI
import com.example.alendarpictures.androidapp.data.remote.dto.WikipediaRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWikipediaApi(): WikipediaAPI {
        return Retrofit.Builder()
            .baseUrl(WikipediaRetrofit.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WikipediaAPI::class.java)
    }

}