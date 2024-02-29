package com.example.alendarpictures.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
data class WikipediaEventsEntity(
    //таблица для большого кол-ва листов (таблица 1 )
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val nameEvent: String = "",
    val dayEvent: String = "",
    val monthEvent: String = "",
    val language: String = "",
    val type: String = "",
    val time: LocalDateTime = LocalDateTime.now()
)
//в одной таблице у меня дожны храниться данные только данные которые будет отражаться на экране с картинкой
//        для этого надо, только текст и ид
//
//        В другой таблице долно храниться все строчки, которые будут показваться списком