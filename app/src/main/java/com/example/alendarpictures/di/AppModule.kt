package com.example.alendarpictures.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.alendarpictures.androidapp.data.remote.api.WikipediaAPI
import com.example.alendarpictures.androidapp.data.remote.dto.WikipediaRetrofit
import com.example.alendarpictures.db.database.AppDatabase
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
    fun provideDatabase(app: Application): AppDatabase {
        return Room
            .databaseBuilder(app, AppDatabase::class.java, "database")
            .build()

    }


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