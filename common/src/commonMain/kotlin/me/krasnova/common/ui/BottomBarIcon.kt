package me.krasnova.common.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.krasnova.common.loadXmlIcon
import me.krasnova.common.theme.InactiveGreyIcon

@Composable
fun BottomBarIcon(
    iconResource: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.height(22.dp)
    ) {
        Icon(
            loadXmlIcon(iconResource),
            contentDescription = title,
            tint = InactiveGreyIcon,
            modifier = Modifier.align(Alignment.Center)
        )
    }


}