package com.coderregio.arkamotest.ui.screen

import com.coderregio.arkamotest.data.model.CharacterModel

data class CharacterUiState(
    val isLoading: Boolean = false,
    val characters: List<CharacterModel> = emptyList(),
    val error: String? = null
)