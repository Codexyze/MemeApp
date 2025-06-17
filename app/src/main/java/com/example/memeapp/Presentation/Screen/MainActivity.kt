package com.example.memeapp.Presentation.Screen

import Screen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.memeapp.LargeScreen
import com.example.memeapp.MutiModuleSample.SimpleMultiModularScreen
import com.example.memeapp.Presentation.Viewmodel.MemeViewModel
import com.example.memeapp.Utility.WindowType
import com.example.memeapp.Utility.rememberWindowType
import com.example.memeapp.ui.theme.MemeAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val memeViewModel: MemeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Call fetchAllMeme to initiate the API request
        memeViewModel.fetchAllMeme()

        setContent {
            MemeAppTheme {
                Scaffold(modifier = Modifier.Companion.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.Companion.padding(innerPadding)) {
                        val screenSize = rememberWindowType()
                        when {
                            screenSize.screenWidthType == WindowType.COMPACT -> {
                                Screen(memeViewModel = memeViewModel)
                            }

                            screenSize.screenWidthType == WindowType.MEDIUM -> {
                                LargeScreen(memeViewModel = memeViewModel)
                            }

                            screenSize.screenWidthType == WindowType.EXPANDED -> {
                                LargeScreen(memeViewModel = memeViewModel)
                            }

                            else -> {
                                LargeScreen(memeViewModel = memeViewModel)
                            }
                        }

                        //SimpleMultiModularScreen()
                    }
                }
            }
        }
    }
}