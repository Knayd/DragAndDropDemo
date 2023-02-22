package com.example.draganddrop

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.draganddrop.ui.theme.DragAndDropTheme

data class HideableWord(
    var hide: Boolean,
    val word: String
)

@Composable
fun HideableWord(word: HideableWord, isInBounds: Boolean) {
    val text = if (word.hide) {
        var hiddenWord = ""
        for (i in 0 until word.word.length) {
            hiddenWord += "_"
        }
        hiddenWord
    } else {
        word.word
    }
    Text(text = text, color = if (isInBounds) Color.Blue else Color.Black)
}

@Preview
@Composable
private fun HideableWordPreview() {
    DragAndDropTheme {
        HideableWord(HideableWord(false, "One"), false)
    }
}