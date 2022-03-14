package me.krasnova.common.utils

import androidx.compose.ui.graphics.Color
import me.krasnova.common.theme.DefaultQuickCardColor

fun getColorByString(text: String?): Color {
    val color = if (text.isNullOrEmpty()) {
        DefaultQuickCardColor
    } else {
        Color(("ff" + text.removePrefix("#").lowercase()).toLong(16))
    }
    return color
}