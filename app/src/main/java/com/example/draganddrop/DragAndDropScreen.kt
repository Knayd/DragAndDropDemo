package com.example.draganddrop

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.draganddrop.ui.theme.DragAndDropTheme
import com.google.accompanist.flowlayout.FlowRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DragAndDropScreen(
    viewModel: MainViewModel
) {
    val draggableWords by viewModel.draggableWords.collectAsState()
    val words by viewModel.wordsToHide.collectAsState()

    Scaffold {
        Column(
            Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            FlowRow(mainAxisSpacing = 2.dp) {
                words.forEach { word ->
                    DropItem<String> { isInBounds, data ->
                        LaunchedEffect(data) {
                            if (data != null && isInBounds && word.word.contains(data)) {
                                viewModel.onWordDropped(word)
                            }
                        }
                        HideableWord(word = word, isInBounds = isInBounds)
                    }
                }
            }
            FlowRow(modifier = Modifier.padding(bottom = 48.dp), mainAxisSpacing = 8.dp) {
                draggableWords.forEach { draggableWord ->
                    DragTarget(dataToDrop = draggableWord) {
                        DraggableWord(text = draggableWord)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun DragAndDropScreenPreview() {
    DragAndDropTheme {
//        DragAndDropScreen()
    }
}