package me.krasnova.common.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

@Composable
expect fun networkImagePainter(url: String): Painter