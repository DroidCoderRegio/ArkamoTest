package com.coderregio.arkamotest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.coderregio.arkamotest.data.remote.ApiClient
import com.coderregio.arkamotest.data.remote.CharacterApiService
import com.coderregio.arkamotest.data.repository.CharacterRepository
import com.coderregio.arkamotest.ui.screen.CharacterScreen
import com.coderregio.arkamotest.ui.theme.ArkamoTestTheme
import com.coderregio.arkamotest.viewmodel.CharacterViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Dependencias
        val apiService = CharacterApiService(ApiClient.client)
        val repository = CharacterRepository(apiService)
        val factory = CharacterViewModelFactory(repository)
        setContent {
            ArkamoTestTheme {
                CharacterScreen(factory = factory)
            }
        }
    }
}