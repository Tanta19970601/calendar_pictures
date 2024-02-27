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

    fun openDialog(typeEvent: String, typeLanguage: String) {
        _state.update { state.value.copy(isShow = true) }
        getWikipediaEvens(typeEvent = typeEvent, typeLanguage = typeLanguage)
    }

    fun closeDialog() {
        _state.update { state.value.copy(isShow = false) }
    }

    fun setDate(date: LocalDate) {
        _state.update { state.value.copy(date = date) }
    }

    fun getWikipediaEvens(typeEvent: String, typeLanguage: String) {
        val day = state.value.date.monthValue.toString()
        val month = state.value.date.dayOfMonth.toString()
        viewModelScope.launch(Dispatchers.IO) {
            wikipediaRepository.getWikipediaEvent(
                day, month, typeEvent, typeLanguage
            )
            closeDialog()
        }
    }
}