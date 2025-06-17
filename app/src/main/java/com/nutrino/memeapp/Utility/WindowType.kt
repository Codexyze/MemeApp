package com.nutrino.memeapp.Utility

import androidx.compose.ui.unit.Dp

enum class WindowType {
    COMPACT,
    MEDIUM,
    EXPANDED
}

data class WindowInfo(
    val screenWidthType: WindowType,
    val screenHeightType: WindowType,
    val screenWidth:Dp,
    val screenHeight: Dp
)