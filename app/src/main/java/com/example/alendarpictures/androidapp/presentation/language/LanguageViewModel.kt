package com.example.alendarpictures.androidapp.presentation.language

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LanguageViewModel @Inject constructor(
) : ViewModel() {

    private val _state = MutableStateFlow(LanguageState())
    val state = _state.asStateFlow()
}