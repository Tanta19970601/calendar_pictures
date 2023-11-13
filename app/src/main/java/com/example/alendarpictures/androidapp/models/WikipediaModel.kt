package com.example.alendarpictures.androidapp.models

data class WikipediaModel(
    val births: List<Birth>,
    val deaths: List<Death>,
    val events: List<Event>,
    val holidays: List<Holiday>,
    val selected: List<Selected>
)