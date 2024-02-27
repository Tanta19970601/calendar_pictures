package com.example.alendarpictures.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EventEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val titleName: String = "",
    val eventName: String = "",
    val dayEvent: String = "",
    val monthEvent: String = "",
)
