package com.example.alendarpictures.androidapp.presentation.calendar

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
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class CalendarViewModel @Inject constructor(
    private val app: Application,
    private val wikipediaRepository: WikipediaRepository
) : ViewModel() {

    private val _state = MutableStateFlow(CalendarState())
    val state = _state.asStateFlow()

//    val options = ImageGenerator.ImageGeneratorOptions.builder()
//        .setImageGeneratorModelDirectory(state.value.requestText)
//        .build()

    fun setDate(date: LocalDate) {
        _state.update { state.value.copy(date = date) }
    }

    fun getWikipediaEvens() = viewModelScope.launch(Dispatchers.IO) {
        val eventsW = wikipediaRepository.getWikipediaEvents(state.value.date)
        _state.update { state.value.copy( requestText = eventsW.body()?.events?.get(0)?.text.orEmpty()) }
    }


}