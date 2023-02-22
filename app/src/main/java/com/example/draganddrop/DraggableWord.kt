package com.example.draganddrop

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.draganddrop.ui.theme.DragAndDropTheme

@Composable
fun DraggableWord(text: String) {
    Text(text = text, color = Color.Red)
}

@Preview
@Composable
fun DraggableWordPreview() {
    DragAndDropTheme {
        DraggableWord("One")
    }
}