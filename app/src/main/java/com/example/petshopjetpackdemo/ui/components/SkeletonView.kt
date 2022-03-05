package com.example.petshopjetpackdemo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.petshopjetpackdemo.ui.theme.Grey

@Composable
fun SkeletonView(
    xShimmer: Float,
    yShimmer: Float,
    gradientWidth: Float,
    cardHeight: Dp,
    padding: Dp
) {
    val colors = listOf(
        Grey.copy(alpha = 0.9f),
        Grey.copy(alpha = 0.2f),
        Grey.copy(alpha = 0.9f)
    )
    val brush = linearGradient(
        colors = colors,
        start = Offset(xShimmer - gradientWidth, yShimmer - gradientWidth),
        end = Offset(xShimmer, yShimmer)
    )
    Surface(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(padding)
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(cardHeight)
                .background(brush = brush)
        )
    }
}
