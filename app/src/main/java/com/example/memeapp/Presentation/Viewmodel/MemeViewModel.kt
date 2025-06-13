package com.example.memeapp.Presentation.Viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.memeapp.data.ApiCalling.RetrofitInstance
import com.example.memeapp.data.Remote.Meme
import kotlinx.coroutines.launch

class MemeViewModel : ViewModel() {
    val memeList = mutableStateOf<Meme?>(null)
    val errorMessage = mutableStateOf("")

    fun fetchAllMeme() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getallMeme()
                Log.d("MemeViewModel", "API response: $response") // Log the response for debugging
                memeList.value = response
            } catch (e: Exception) {
                Log.e("MemeViewModel", "Error: ${e.message}") // Log the error
                errorMessage.value = "Error fetching data: ${e.message}"
            }
        }
    }
}