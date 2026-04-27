package com.coderregio.arkamotest.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SnackbarError(message: String, actionLabel: String? = null, onAction: (() -> Unit)? = null) {
    Snackbar(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        containerColor = Color.Red,
        contentColor = Color.White,
        action = {
            if (actionLabel != null && onAction != null) {
                TextButton(onClick = onAction) {
                    Text(actionLabel, color = Color.White)
                }
            }
        }
    ) {
        Text(message)
    }
}