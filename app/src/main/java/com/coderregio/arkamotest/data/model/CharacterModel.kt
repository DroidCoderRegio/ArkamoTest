package com.coderregio.arkamotest.data.model

data class CharacterModel(
    val id: Int,
    val name: String,
    val status: CharacterStatusModel,
    val image: String
)

enum class CharacterStatusModel(val value: String) {
    ALIVE("alive"),
    DEAD("dead"),
    UNKNOWN("unknown");

    companion object {
        fun from(value: String?): CharacterStatusModel {
            return entries.firstOrNull { it.value == value?.lowercase() }
                ?: UNKNOWN
        }
    }
}