package com.coderregio.arkamotest.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.coderregio.arkamotest.ui.components.CenteredButton
import com.coderregio.arkamotest.ui.components.CharacterItem
import com.coderregio.arkamotest.ui.components.LoadingComponent
import com.coderregio.arkamotest.ui.components.SnackbarError
import com.coderregio.arkamotest.viewmodel.CharacterViewModel
import com.coderregio.arkamotest.viewmodel.CharacterViewModelFactory

@Composable
fun CharacterScreen(
    factory: CharacterViewModelFactory
) {
    val viewModel: CharacterViewModel = viewModel(factory = factory)
    val state by viewModel.state.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    LaunchedEffect(key1 = state.error) {
        state.error?.let {
            val result = snackbarHostState.showSnackbar(
                message = it,
                actionLabel = "Reintentar",
                duration = SnackbarDuration.Indefinite
            )

            if (result == SnackbarResult.ActionPerformed) {
                viewModel.getCharacters()
            }
        }
    }
    Scaffold(
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState,
                snackbar = { snackbarData ->
                    SnackbarError(
                        message = snackbarData.visuals.message,
                        actionLabel = snackbarData.visuals.actionLabel,
                        onAction = { snackbarData.performAction() }
                    )
                }
            )
        }
    ) { innerPadding ->
        Box(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when {
                state.isLoading -> LoadingComponent()

                !state.hasLoaded -> {
                    CenteredButton("Cargar datos") {
                        viewModel.getCharacters()
                    }
                }

                else -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(
                            items = state.characters,
                            key = { it.id }
                        ) { item ->
                            CharacterItem(item)
                        }
                    }
                }
            }
        }
    }
}