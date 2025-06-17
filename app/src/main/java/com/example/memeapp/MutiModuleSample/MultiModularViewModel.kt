package com.example.memeapp.MutiModuleSample

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

    fun getAllmemes(){
        viewModelScope.launch {
            repository.getAllMemes().collect { meme->
                _memeState.value = meme
            }
        }
    }

}