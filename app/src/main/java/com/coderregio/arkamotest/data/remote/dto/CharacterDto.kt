package com.coderregio.arkamotest.data.remote.dto
import kotlinx.serialization.Serializable

@Serializable
data class CharacterDto(
    val id: Int? = 0,
    val name: String? = null,
    val status: String? = null,
    val image: String? = null
)