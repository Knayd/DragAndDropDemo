package com.example.draganddrop

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var isDragging by mutableStateOf(false)
        private set

    var items by mutableStateOf(emptyList<PersonUiItem>())
        private set

    var people = mutableStateListOf<PersonUiItem>()
        private set

    init {
        items = listOf(
            PersonUiItem("Person 1", "1", Color.Black),
            PersonUiItem("Person 2", "2", Color.Red),
            PersonUiItem("Person 3", "3", Color.Green),
            PersonUiItem("Person 4", "4", Color.Black),
            PersonUiItem("Person 5", "5", Color.Yellow)
        )
    }

    fun startDragging() {
        isDragging = true
    }

    fun stopDragging() {
        isDragging = false
    }

    fun addPerson(person: PersonUiItem) {
        people.add(person)
    }
}