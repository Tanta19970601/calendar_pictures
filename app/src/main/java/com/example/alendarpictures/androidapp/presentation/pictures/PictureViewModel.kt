package com.example.alendarpictures.androidapp.presentation.pictures

import android.app.Application
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alendarpictures.androidapp.data.remote.EventsRepository
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
    private val savedStateHandle: SavedStateHandle,
    private val eventsRepository: EventsRepository
) : ViewModel() {

    companion object {
        const val EVENT_ID = "event_id"
    }

    private val eventId = savedStateHandle.get<Long>(EVENT_ID) ?: 0
    private val _state = MutableStateFlow(PictureState())
    val state = _state.asStateFlow()

    init {
        getWikipediaName()
    }


    fun getWikipediaName() = viewModelScope.launch(Dispatchers.IO) {
        val eventsW = eventsRepository.getOne(eventId)
        _state.update { _state.value.copy(nameEvents = eventsW.titleName) }
//        closeDialog()
    }
}
