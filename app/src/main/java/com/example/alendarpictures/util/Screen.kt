package com.example.alendarpictures.util

import com.example.alendarpictures.androidapp.presentation.event.EventListViewModel
import com.example.alendarpictures.androidapp.presentation.pictures.PictureViewModel
import org.intellij.lang.annotations.Language

sealed class Screen(val route: String) {

    object CalendarScreen : Screen("calendar_screen")

    object LanguageScreen : Screen("language_screen")
    object EventListScreen : Screen("event_list_screen") {
        fun openRoute(event: String, language: String, date: String) =
            route + "?${EventListViewModel.EVENT}=$event" +
                    "&${EventListViewModel.LANGUAGE}=$language" +
                    "&${EventListViewModel.DATE}=$date"

    }

    object PictureScreen : Screen("picture_screen") {
        fun openRoute(eventId: Long) = route + "?${PictureViewModel.EVENT_ID}=$eventId"
    }
}
