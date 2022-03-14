package me.krasnova.common.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.krasnova.common.theme.InactiveGreyIcon
import me.krasnova.common.ui.theme.PetshopTheme
import me.krasnova.common.theme.White
import com.google.accompanist.insets.navigationBarsPadding
import me.krasnova.common.ui.BottomBarIcon
import me.krasnova.common.ui.BottomBarItems

@Composable
fun BottomNavigationBar(
    tabs: Array<BottomBarItems>
) {
    Surface(
        color = PetshopTheme.colors.uiBackground,
        elevation = 16.dp,
        modifier = Modifier
            .navigationBarsPadding()
            .shadow(elevation = 10.dp)
            .clip(shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(BottomNavHeight)
                .selectableGroup(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            tabs.forEach { item ->
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
                            style = MaterialTheme.typography.body2,
                            maxLines = 1
                        )
                    },
                    selectedContentColor = White,
                    unselectedContentColor = White.copy(0.4f),
                    alwaysShowLabel = true,
                    selected = false,
                    onClick = {/* TODO */ }
                )
            }
        }
    }
}

private val BottomNavHeight = 56.dp

@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationBar(
        tabs = BottomBarItems.values()
    )
}