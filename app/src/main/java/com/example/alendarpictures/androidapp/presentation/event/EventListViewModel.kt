package com.example.alendarpictures.androidapp.presentation.event

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
class EventListViewModel @Inject constructor(
    private val app: Application,
    private val wikipediaRepository: WikipediaRepository
) : ViewModel() {

    private val _state = MutableStateFlow(EventListState())
    val state = _state.asStateFlow()


    fun getTitle() {
        viewModelScope.launch(Dispatchers.IO) {
            val eventTitle = wikipediaRepository.getNameEvent()
            eventTitle.let { eventTitle ->
                _state.update {
                    it.copy(title = eventTitle.size.toString())
                }
            }
        }
    }
}