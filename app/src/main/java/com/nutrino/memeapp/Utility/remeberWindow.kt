package com.nutrino.memeapp.Utility

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

@Composable
fun rememberWindowType(modifier: Modifier = Modifier): WindowInfo {
    val configuration = LocalConfiguration.current
    return WindowInfo(
        screenWidthType = when{
            configuration.screenWidthDp < 600 -> WindowType.COMPACT
            configuration.screenWidthDp < 800 -> WindowType.MEDIUM
            else->{
                WindowType.EXPANDED
            }

        },
        screenHeightType =  when {
            configuration.screenHeightDp < 480 ->WindowType.COMPACT
            configuration.screenHeightDp < 900 ->WindowType.MEDIUM
            else -> WindowType.EXPANDED
        },
        screenWidth = configuration.screenWidthDp.dp,
        screenHeight = configuration.screenHeightDp.dp
    )

}