package com.example.alendarpictures.androidapp.presentation.pictures

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alendarpictures.androidapp.data.remote.WikipediaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PictureViewModel @Inject constructor(
    private val app: Application,
    private val wikipediaRepository: WikipediaRepository
) : ViewModel() {

    private val _state = MutableStateFlow(PictureState())
    val state = _state.asStateFlow()

    init {
        getWikipediaName()
    }

    fun getWikipediaName() = viewModelScope.launch(Dispatchers.IO) {
        val eventsW = wikipediaRepository.getNameEvent()
//        eventsW?.let { event ->
//            _state.update {
//                it.copy(nameEvents = event.nameEvent)
//            }
//        }
    }
}