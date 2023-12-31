package com.example.alendarpictures.androidapp.presentation.calendar

import java.time.LocalDate

data class CalendarState(
    val date: LocalDate = LocalDate.now(),
    val requestText: String = ""
)
