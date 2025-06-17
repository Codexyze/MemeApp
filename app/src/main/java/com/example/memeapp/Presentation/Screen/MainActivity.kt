package com.example.memeapp.Presentation.Screen

import Screen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.memeapp.Utility.WindowType
import com.example.memeapp.Utility.rememberWindowType
import com.example.memeapp.ui.theme.MemeAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MemeAppTheme {
                Scaffold(modifier = Modifier.Companion.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.Companion.padding(innerPadding)) {
                        val screenSize = rememberWindowType()
                        when {
                            screenSize.screenWidthType == WindowType.COMPACT -> {
                                Screen()
                            }

                            screenSize.screenWidthType == WindowType.MEDIUM -> {
                                LargeScreen()
                            }

                            screenSize.screenWidthType == WindowType.EXPANDED -> {
                                LargeScreen()
                            }

                            else -> {
                                LargeScreen()
                            }
                        }

                        //SimpleMultiModularScreen()
                    }
                }
            }
        }
    }
}