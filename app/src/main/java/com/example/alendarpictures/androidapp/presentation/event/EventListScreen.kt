package com.example.alendarpictures.androidapp.presentation.event


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController


@Composable
fun EventListScreen(
    navController: NavController,
    viewModel: EventListViewModel = hiltViewModel(),
    state: EventListState = viewModel.state.collectAsStateWithLifecycle().value,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    )
    {
        item {
            Spacer(modifier = Modifier.height(1.dp))
        }
        items(items = state.listEvens) {
            Text(text = state.title)
        }

    }

}
