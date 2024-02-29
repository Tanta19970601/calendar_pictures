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

    @Query("SELECT * FROM wikipediaeventsentity ORDER BY time DESC")
    suspend fun getNameEvent(): WikipediaEventsEntity?

    @Query("SELECT * FROM wikipediaeventsentity ORDER BY nameEvent DESC")
    suspend fun getListEvent(): List<WikipediaEventsEntity>

    @Insert
    suspend fun insert(wikipediaEventsEntity: WikipediaEventsEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun replace(wikipediaEventsEntity: WikipediaEventsEntity): Long

    @Update
    suspend fun update(wikipediaEventsEntity: WikipediaEventsEntity)

    @Delete
    suspend fun delete(wikipediaEventsEntity: WikipediaEventsEntity)
}