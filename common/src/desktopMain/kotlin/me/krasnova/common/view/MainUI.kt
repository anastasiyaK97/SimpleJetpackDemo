package me.krasnova.common.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.krasnova.common.DesktopAppState
import me.krasnova.common.ResString
import me.krasnova.common.model.QuickCard
import me.krasnova.common.model.toQuickCardData
import me.krasnova.common.ui.ProfileSkeletons
import me.krasnova.common.ui.QuickCardGrid
import me.krasnova.common.ui.TitleBar

@Composable
fun MainUI(content: DesktopAppState) {

    LaunchedEffect(true) {
        content.initData()
    }

    Column {
        TopContent()
        Column(modifier = Modifier.padding(16.dp)) {
            when (content.isLoading()) {
                true -> ProfileSkeletons(imageHeight = 300.dp)
                else -> QuickCardGrid(cardsCollection = content.sectionsCollection.value)
            }
        }
    }
}

@Composable
fun TopContent() {
    TitleBar(text = ResString.topBarPersonalAccountTitle)
    Spacer(modifier = Modifier.height(10.dp))
}