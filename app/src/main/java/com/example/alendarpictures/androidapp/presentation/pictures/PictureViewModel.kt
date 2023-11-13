package com.example.alendarpictures.androidapp.presentation.pictures

import android.app.Application
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class PictureViewModel @Inject constructor(private val app: Application) : ViewModel() {

    private val _state = MutableStateFlow(PictureState())
    val state = _state.asStateFlow()

    fun getPicture () {

    }
}