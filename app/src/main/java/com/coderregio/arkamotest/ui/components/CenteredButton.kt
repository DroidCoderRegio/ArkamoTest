package com.coderregio.arkamotest.ui.components

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun BoxScope.CenteredButton(text: String, onClick: () -> Unit) {
    Button(modifier = Modifier.align(Alignment.Center), onClick = onClick) {
        Text(text)
    }
}