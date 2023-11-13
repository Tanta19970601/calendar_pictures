package com.example.alendarpictures.androidapp.presentation.pictures


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.alendarpictures.R


@Composable
fun PictureScreen(
    navController: NavController,
    viewModel: PictureViewModel = hiltViewModel(),
    state: PictureState = viewModel.state.collectAsStateWithLifecycle().value
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = state.nameEvents)
        Image(
            painter = painterResource(id = R.mipmap.ic_image),
            contentDescription = null
        )

    }
}