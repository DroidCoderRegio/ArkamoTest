package com.coderregio.arkamotest.data.repository

import com.coderregio.arkamotest.data.model.CharacterModel
import com.coderregio.arkamotest.data.remote.CharacterApiService
import com.coderregio.arkamotest.data.remote.mapper.toDomain

class CharacterRepository(
    private val apiService: CharacterApiService
) {

    suspend fun getCharacters(): List<CharacterModel> {
        val response = apiService.getCharacters()
        return response.results.map { it.toDomain() }
    }
}