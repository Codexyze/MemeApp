package com.example.memeapp.Presentation.Viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Repository.Meme
import com.example.domain.Repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MultiModularViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private val _memeState = MutableStateFlow<Meme?>(null)
    val memeState = _memeState.asStateFlow()
    private val _errorMessageSate = MutableStateFlow<String?>(null)
    val errorMessageSate = _errorMessageSate.asStateFlow()

    fun getAllmemes(){
        try {
            viewModelScope.launch {
                repository.getAllMemes().collect { meme->
                    _memeState.value = meme
                }
            }
        } catch (e: Exception) {
            _errorMessageSate.value = "Error fetching data: ${e.message}"
        }

    }

}