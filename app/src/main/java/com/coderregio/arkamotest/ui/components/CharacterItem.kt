package com.coderregio.arkamotest.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.coderregio.arkamotest.data.model.CharacterModel

@Composable
fun CharacterItem(character: CharacterModel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        with(character) {
            Text(text = name.replaceFirstChar { it.uppercase() })
            Text(text = status.value.replaceFirstChar { it.uppercase() })
        }
    }
}