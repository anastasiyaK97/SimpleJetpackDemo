package me.krasnova.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import me.krasnova.common.theme.Fonts
import me.krasnova.common.theme.InactiveGreyIcon
import me.krasnova.common.theme.White
import me.krasnova.common.ui.BottomBarIcon
import me.krasnova.common.ui.BottomBarItems
import me.krasnova.common.view.MainUI

@Composable
fun DesktopApp(content: DesktopAppState) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = White
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            MainUI(content)
            BottomNavigationBar(Modifier.align(Alignment.BottomCenter))
        }
    }
}

@Composable
fun BottomNavigationBar(modifier: Modifier) {
    BottomNavigation(
        modifier.fillMaxWidth()
            .shadow(elevation = 10.dp)
            .clip(shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
    ) {
        BottomBarItems.values().forEach { item ->
            BottomNavigationItem(
                icon = {
                    BottomBarIcon(
                        iconResource = item.iconRes,
                        title = item.title
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        color = InactiveGreyIcon,
                        fontFamily = Fonts.roboto(),
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Normal,
                        maxLines = 1
                    )
                },
                selectedContentColor = White,
                unselectedContentColor = White.copy(0.4f),
                alwaysShowLabel = true,
                selected = false,
                onClick = {/* TODO */ },
                modifier = Modifier.background(White)
            )
        }
    }
}
