package com.coderregio.arkamotest.data.remote.dto
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    val results: List<CharacterDto>? = listOf()
)