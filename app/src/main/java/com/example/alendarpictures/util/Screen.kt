package com.example.alendarpictures.util

sealed class Screen(val route: String) {

    object CalendarScreen : Screen("calendar_screen")
    object PictureScreen : Screen("picture_screen")
    object LanguageScreen : Screen("language_screen")
}