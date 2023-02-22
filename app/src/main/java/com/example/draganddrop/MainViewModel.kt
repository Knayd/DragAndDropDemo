package com.example.draganddrop

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel : ViewModel() {

    private val text = "We believe in being honest, true, chaste, benevolent"

    val wordsToHide = MutableStateFlow(listOf<HideableWord>())
    val draggableWords = MutableStateFlow(listOf("honest", "benevolent", "chaste"))

    init {
        wordsToHide.value = text.split(" ").map { HideableWord(it == "chaste," || it == "honest," || it == "benevolent", it) }
    }

    fun onWordDropped(droppedWord: HideableWord) {
        wordsToHide.value.find { it == droppedWord }?.hide = false
    }
}