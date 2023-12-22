package com.waterissue.sayangair.presentation.home.component

import androidx.compose.ui.graphics.vector.ImageVector
import com.waterissue.sayangair.presentation.main.component.Screen

data class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val screen: Screen
)