package me.krasnova.common.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import me.krasnova.common.ui.theme.Green

@Composable
fun AppBarIcon(@DrawableRes iconResourceId: Int, modifier: Modifier, onClickAction: () -> Unit) {
    Icon(
        painter = painterResource(id = iconResourceId),
        contentDescription = null,
        tint = Green,
        modifier = modifier
            .padding(end = 16.dp)
            .clickable { onClickAction.invoke() }
    )
}