package com.example.alendarpictures.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
data class WikipediaEventsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val nameEvent: String = "",
    val dayEvent: String = "",
    val monthEvent: String = "",
    val language: String = "",
    val type: String = "",
    val time: LocalDateTime = LocalDateTime.now()
)
