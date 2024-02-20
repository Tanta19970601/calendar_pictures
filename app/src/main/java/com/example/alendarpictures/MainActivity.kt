package com.example.alendarpictures

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.alendarpictures.androidapp.presentation.calendar.CalendarScreen
import com.example.alendarpictures.androidapp.presentation.language.LanguageScreen
import com.example.alendarpictures.androidapp.presentation.pictures.PictureScreen
import com.example.alendarpictures.ui.theme.СalendarPicturesTheme
import com.example.alendarpictures.util.Screen
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            СalendarPicturesTheme {
                NavHost(
                    navController = navController,
                    startDestination = Screen.CalendarScreen.route
                ) {
                    composable(route = Screen.CalendarScreen.route) {
                        CalendarScreen(navController = navController)
                    }
                    composable(route = Screen.PictureScreen.route) {
                        PictureScreen(navController = navController)
                    }
                    composable(route = Screen.LanguageScreen.route) {
                        LanguageScreen(navController = navController)

                    }
                }
            }
        }
    }
}