package com.example.alendarpictures.androidapp.presentation.event

import com.example.alendarpictures.androidapp.domain.modals.IdAndNameList
import com.example.alendarpictures.db.entities.WikipediaEventsEntity

data class EventListState(
    val listEvens: List<IdAndNameList> = emptyList()
)
