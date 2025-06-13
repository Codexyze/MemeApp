package com.example.memeapp

import MemeViewModel
import Screen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.memeapp.Utility.WindowType
import com.example.memeapp.Utility.rememberWindowType
import com.example.memeapp.ui.theme.MemeAppTheme

class MainActivity : ComponentActivity() {
    private val memeViewModel: MemeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Call fetchAllMeme to initiate the API request
        memeViewModel.fetchAllMeme()

        setContent {
            MemeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        val screenSize = rememberWindowType()
                        when{
                            screenSize.screenWidthType == WindowType.COMPACT->{
                                Screen(memeViewModel = memeViewModel)
                            }
                            screenSize.screenWidthType== WindowType.MEDIUM->{
                                LargeScreen(memeViewModel = memeViewModel)
                            }
                            screenSize.screenWidthType == WindowType.EXPANDED->{
                                LargeScreen(memeViewModel = memeViewModel)
                            }
                            else->{
                                LargeScreen(memeViewModel = memeViewModel)
                            }
                        }
                    }
                }
            }
        }
    }
}


