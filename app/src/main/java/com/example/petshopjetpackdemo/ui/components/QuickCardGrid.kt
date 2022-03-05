package com.example.petshopjetpackdemo.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.petshopjetpackdemo.model.QuickCard
import com.example.petshopjetpackdemo.ui.theme.White
import com.example.petshopjetpackdemo.ui.theme.montserratFontFamily
import com.example.petshopjetpackdemo.ui.utils.getColorByString

@Composable
fun QuickCardGrid(
    cardsCollection: List<QuickCard>,
    columns: Int = 2,
    cardHeightDp: Int = 103
) {
    Spacer(Modifier.height(TopPaddingDp))
    Grid(columns = columns) {
        cardsCollection.forEachIndexed { index, card ->
            val endPadding = if (index % columns == 0) BetweenCardsPaddingDp else 0.dp
            QuickCardLayout(
                card = card,
                cardHeightDp = cardHeightDp,
                modifier = Modifier.padding(end = endPadding, bottom = BetweenCardsPaddingDp)
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun QuickCardLayout(card: QuickCard, cardHeightDp: Int, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(CardCornerRadiusDp),
        modifier = modifier
            .height(cardHeightDp.dp),
        onClick = card.clickAction,
        backgroundColor = getColorByString(card.quickCardData.color)
    ) {
        Box {
            Image(
                painter = rememberImagePainter(card.quickCardData.imageUrl),
                contentScale = ContentScale.Fit,
                contentDescription = null,
                alignment = Alignment.BottomEnd,
                modifier = Modifier.align(Alignment.BottomEnd)
            )
            Text(
                text = card.quickCardData.title,
                fontFamily = montserratFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 13.sp,
                color = White,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 10.dp)
            )
        }
    }
}

@Composable
fun Grid(
    modifier: Modifier = Modifier,
    columns: Int = 2,
    content: @Composable () -> Unit
) {
    Layout(
        content = content,
        modifier = modifier
    ) { measurables, constraints ->
        val itemWidth = constraints.maxWidth / columns
        val itemConstraints = constraints.copy(
            minWidth = itemWidth,
            maxWidth = itemWidth
        )

        val placeables = measurables.map { it.measure(itemConstraints) }

        val columnHeights = Array(columns) { 0 }
        placeables.forEachIndexed { index, placeable ->
            val column = index % columns
            columnHeights[column] += placeable.height
        }

        val height = (columnHeights.maxOrNull() ?: constraints.minHeight)
            .coerceAtMost(constraints.maxHeight)

        layout(
            width = constraints.maxWidth,
            height = height
        ) {
            val columnY = Array(columns) { 0 }
            placeables.forEachIndexed { index, placeable ->
                val column = index % columns
                placeable.placeRelative(
                    x = column * itemWidth,
                    y = columnY[column]
                )
                columnY[column] += placeable.height
            }
        }
    }
}

private val TopPaddingDp = 8.dp
private val BetweenCardsPaddingDp = 10.dp
private val CardCornerRadiusDp = 8.dp