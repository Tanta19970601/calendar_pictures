package com.example.alendarpictures.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.alendarpictures.db.entities.EventEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EventDao {

    @Query("SELECT * FROM evententity")
    fun getAll(): Flow<List<EventEntity>>

//    @Query("SELECT * FROM wikipediaeventsentity ORDER BY id = id  DESC")
//    suspend fun getId (id: Long): Int

    @Insert
    suspend fun insert(eventEntity: EventEntity): Long

    @Update
    suspend fun update(eventEntity: EventEntity)

    @Delete
    suspend fun delete(eventEntity: EventEntity)
}