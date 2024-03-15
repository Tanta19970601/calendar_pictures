package com.example.alendarpictures.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.alendarpictures.db.entities.WikipediaEventsEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface WikipediaEventsDao {


    @Query("SELECT * FROM wikipediaeventsentity")
    fun getAll(): Flow<List<WikipediaEventsEntity>>

    @Query(
        """SELECT * FROM wikipediaeventsentity WHERE dayEvent = :dayOfMonth AND monthEvent = :monthValue 
             AND type = :typeEvent AND language = :typeLanguage"""
    )
    suspend fun getListEvent(
        monthValue: String,
        dayOfMonth: String,
        typeEvent: String,
        typeLanguage: String
    ): List<WikipediaEventsEntity>

//    @Query("SELECT * FROM wikipediaeventsentity ORDER BY nameEvent DESC")
//    suspend fun getNameEvent(): List<WikipediaEventsEntity>


    @Insert
    suspend fun insert(wikipediaEventsEntity: WikipediaEventsEntity): Long

    @Update
    suspend fun update(wikipediaEventsEntity: WikipediaEventsEntity)

    @Delete
    suspend fun delete(wikipediaEventsEntity: WikipediaEventsEntity)
}