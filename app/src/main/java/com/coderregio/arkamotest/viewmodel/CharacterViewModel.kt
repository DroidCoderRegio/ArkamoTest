package com.coderregio.arkamotest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coderregio.arkamotest.data.repository.CharacterRepository
import com.coderregio.arkamotest.ui.screen.CharacterUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CharacterViewModel(
    private val repository: CharacterRepository
) : ViewModel() {

    private val mutableState = MutableStateFlow(CharacterUiState(isLoading = false))
    val state = mutableState.asStateFlow()

    fun getCharacters() {
        viewModelScope.launch {
            mutableState.update { it.copy(isLoading = true, error = null) }
            try {
                val characters = repository.getCharacters()
                mutableState.update {
                    it.copy(
                        isLoading = false,
                        characters = characters,
                        hasLoaded = true
                    )
                }
            } catch (e: Exception) {
                mutableState.update {
                    it.copy(
                        isLoading = false,
                        error = "Error al cargar personajes",
                        hasLoaded = true
                    )
                }
            }
        }
    }
}

