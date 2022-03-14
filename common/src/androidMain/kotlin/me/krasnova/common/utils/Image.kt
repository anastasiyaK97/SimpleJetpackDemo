package me.krasnova.common.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import coil.compose.rememberImagePainter

@Composable
actual fun networkImagePainter(url: String): Painter =
    rememberImagePainter(url)
