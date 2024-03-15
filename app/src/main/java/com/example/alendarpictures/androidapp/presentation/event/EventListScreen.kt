package com.example.alendarpictures.androidapp.presentation.event


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.alendarpictures.R
import com.example.alendarpictures.util.Screen
import kotlin.math.round


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventListScreen(
    navController: NavController,
    viewModel: EventListViewModel = hiltViewModel(),
    state: EventListState = viewModel.state.collectAsStateWithLifecycle().value,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { stringResource(id = R.string.list_events) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(Screen.CalendarScreen.route) })
                    {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back icon"
                        )
                    }
                })
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentPadding = it

        ) {
            item {
                Spacer(modifier = Modifier.height(1.dp))
            }
            items(items = state.listEvens) {
                OutlinedCard(
                    modifier = Modifier.padding(8.dp),
                    onClick = {
                        navController.navigate(Screen.PictureScreen.openRoute(it.id))
                    },
                    border = BorderStroke(3.dp, Color.Black),
                ) {
                    Text(text = it.title)
                }
            }
        }
    }
}

