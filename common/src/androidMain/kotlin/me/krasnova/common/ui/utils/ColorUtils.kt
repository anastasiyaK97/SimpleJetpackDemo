package me.krasnova.common.ui.utils

import androidx.compose.ui.graphics.Color
import me.krasnova.common.ui.theme.DefaultQuickCardColor

fun getColorByString(text: String?): Color {
    val color = if (text.isNullOrEmpty()) {
        DefaultQuickCardColor
    } else {
        val intColor = android.graphics.Color.parseColor(text)
        Color(intColor.toLong())
    }
    return color
}