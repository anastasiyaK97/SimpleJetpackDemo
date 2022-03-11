package me.krasnova.common.ui.screen.Profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import me.krasnova.common.model.QuickCard
import me.krasnova.common.model.toQuickCardData
import me.krasnova.common.ui.components.QuickCardGrid
import me.krasnova.common.ui.theme.PetshopTheme

@Composable
fun ProfileScreen(
    navHostController: NavHostController,
    navBackStackEntry: NavBackStackEntry,
    viewModel: ProfileViewModel = viewModel(factory = ProfileViewModel.provideFactory(navHostController, navBackStackEntry))
) {
    val uiState = viewModel.uiState.observeAsState()
    val profileSections by viewModel.profileSection.collectAsState()

    when (uiState.value) {
        is UiProfileState.Success -> {
            Column(
                modifier = Modifier
                    .background(PetshopTheme.colors.uiBackground)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                QuickCardGrid(
                    profileSections.map {
                        QuickCard(
                            quickCardData = it.toQuickCardData(),
                            clickAction = { viewModel.navigateToProfileSection(it) }
                        )
                    }
                )
            }
        }
        UiProfileState.Loading -> {
            ProfileSkeletons(
                imageHeight = 150.dp,
                padding = 16.dp
            )
            viewModel.updateData()
        }
        else -> Unit
    }
}
