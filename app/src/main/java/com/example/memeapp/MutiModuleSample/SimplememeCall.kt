package com.example.memeapp.MutiModuleSample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SimpleMultiModularScreen(multiModularViewModel: MultiModularViewModel = hiltViewModel()) {
    val memestate= multiModularViewModel.memeState.collectAsState()
    LaunchedEffect(Unit) {
        multiModularViewModel.getAllmemes()
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Text(memestate.value?.memes.toString())
    }

}