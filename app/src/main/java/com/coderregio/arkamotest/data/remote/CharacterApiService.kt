package com.coderregio.arkamotest.data.remote

import com.coderregio.arkamotest.data.remote.dto.CharacterResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class CharacterApiService(
    private val client: HttpClient
) {

    suspend fun getCharacters(): CharacterResponse {
        return client.get("${ApiClient.getBaseUrl()}/character").body()
    }
}