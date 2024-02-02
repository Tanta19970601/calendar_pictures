package com.example.alendarpictures.db.converters

import androidx.room.TypeConverter
import java.time.LocalDateTime

object Converter {

    @TypeConverter
    fun localDateToString(localDate: LocalDateTime): String {
        return localDate.toString()
    }

    @TypeConverter
    fun stringToLocalDate(localDate: String): LocalDateTime {
        return LocalDateTime.parse(localDate)
    }
}