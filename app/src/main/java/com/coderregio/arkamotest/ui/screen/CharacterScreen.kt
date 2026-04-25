package com.coderregio.arkamotest.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.coderregio.arkamotest.ui.components.LoadingComponent
import com.coderregio.arkamotest.viewmodel.CharacterViewModel
import com.coderregio.arkamotest.viewmodel.CharacterViewModelFactory

@Composable
fun CharacterScreen(
    factory: CharacterViewModelFactory
) {
    val viewModel: CharacterViewModel = viewModel(factory = factory)
    val state by viewModel.state.collectAsState()


    if (state.isLoading) {
        LoadingComponent()
    }
}