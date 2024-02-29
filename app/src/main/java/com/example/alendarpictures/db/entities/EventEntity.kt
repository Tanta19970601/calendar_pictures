package com.example.alendarpictures.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
data class EventEntity(
    //только для хварненеи нимаенование текса (таблица 2)
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val titleName: String = "",
)
