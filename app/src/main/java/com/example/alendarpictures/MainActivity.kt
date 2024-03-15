package com.example.alendarpictures

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.alendarpictures.androidapp.presentation.calendar.CalendarScreen
import com.example.alendarpictures.androidapp.presentation.event.EventListScreen
import com.example.alendarpictures.androidapp.presentation.event.EventListViewModel
import com.example.alendarpictures.androidapp.presentation.event.EventListViewModel.Companion.DATE
import com.example.alendarpictures.androidapp.presentation.event.EventListViewModel.Companion.EVENT
import com.example.alendarpictures.androidapp.presentation.event.EventListViewModel.Companion.LANGUAGE
import com.example.alendarpictures.androidapp.presentation.language.LanguageScreen
import com.example.alendarpictures.androidapp.presentation.pictures.PictureScreen
import com.example.alendarpictures.androidapp.presentation.pictures.PictureViewModel.Companion.EVENT_ID
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
                    composable(
                        route = Screen.EventListScreen.route
                                + "?$EVENT={$EVENT}"
                                + "&$LANGUAGE={$LANGUAGE}"
                                + "&$DATE={$DATE}",
                        arguments = listOf(
//                            navArgument(
//                                name = EVENT
//                            ) {
//                                type = NavType.StringType
//                                defaultValue = ""
//                            }
                            navArgument(
                                name = LANGUAGE
                            ) {
                                type = NavType.StringType
                                defaultValue = ""
                            },
                            navArgument(
                                name = DATE
                            ) {
                                type = NavType.StringType
                                defaultValue = ""
                            }
                        )
                    ) {
                        EventListScreen(navController = navController)
                    }

                    composable(
                        route = Screen.PictureScreen.route + "?$EVENT_ID={$EVENT_ID}",
                        arguments = listOf(
                            navArgument(
                                name = EVENT_ID
                            ) {
                                type = NavType.LongType
                                defaultValue = 0
                            }
                        )
                    ) {
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