package com.example.petshopjetpackdemo.ui.utils

import androidx.compose.ui.graphics.Color
import com.example.petshopjetpackdemo.ui.theme.DefaultQuickCardColor

fun getColorByString(text: String?): Color {
    val color = if (text.isNullOrEmpty()) {
        DefaultQuickCardColor
    } else {
        val intColor = android.graphics.Color.parseColor(text)
        Color(intColor.toLong())
    }
    return color
}