package com.example.alendarpictures.androidapp.presentation.event

import android.app.Application
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alendarpictures.androidapp.data.remote.EventsRepository
import com.example.alendarpictures.androidapp.data.remote.WikipediaRepository
import com.example.alendarpictures.androidapp.domain.modals.IdAndNameList
import com.example.alendarpictures.androidapp.presentation.pictures.PictureViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.Language
import java.time.LocalDate
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class EventListViewModel @Inject constructor(
    private val app: Application,
    private val wikipediaRepository: WikipediaRepository,
    private val eventsRepository: EventsRepository,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    companion object {
        const val EVENT = "event"
        const val LANGUAGE = "language"
        const val DATE = "date"

    }

    private val event = savedStateHandle.get<String>(EVENT).orEmpty()
    private val language = savedStateHandle.get<String>(LANGUAGE).orEmpty()
    private val date = LocalDate.parse(savedStateHandle.get<String>(DATE).orEmpty())
    private val _state = MutableStateFlow(EventListState())
    val state = _state.asStateFlow()

    init {
        getTitle()
    }

    private fun getTitle() {
        viewModelScope.launch(Dispatchers.IO) {
            val eventTitle =
                wikipediaRepository.getNameEventList(
                    monthValue = date.monthValue.toString(),
                    dayOfMonth = date.dayOfMonth.toString(),
                    typeEvent = event,
                    typeLanguage = language
                )
            val idAndNameList = mutableListOf<IdAndNameList>()
            eventTitle.forEach { it ->
                idAndNameList.add(IdAndNameList(it.id, it.nameEvent))
                _state.update {
                    it.copy(listEvens = idAndNameList)
                }
            }
        }
    }
}

//   LocalDateTime.parse()

