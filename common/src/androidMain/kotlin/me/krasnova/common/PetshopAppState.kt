package me.krasnova.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import me.krasnova.common.ui.components.BottomBarItems
import me.krasnova.common.ui.screen.ProfileSectionTitleKey
import me.krasnova.common.ui.screen.Screen

@Composable
fun rememberPetshopAppState(
    navController: NavHostController = rememberNavController()
) =
    remember(navController) {
        PetshopAppState(navController)
    }

@Stable
class PetshopAppState(
    val navController: NavHostController
) {
    val bottomBarTabs = BottomBarItems.values()

    val toolbarTitle: String?
        @Composable get() = when (getCurrentRoute()) {
            Screen.ProfileScreen.route -> stringResource(id = R.string.top_bar_personal_account_title)
            Screen.ProfileSectionScreen.route + "/{$ProfileSectionTitleKey}" -> navController
                .currentBackStackEntryAsState().value?.arguments?.getString(ProfileSectionTitleKey)
            else -> null
        }

    val toolbarPreviousTitle: String?
        @Composable get() = when (getCurrentRoute()) {
            Screen.ProfileScreen.route -> null
            Screen.ProfileSectionScreen.route + "/{$ProfileSectionTitleKey}" -> stringResource(id = R.string.top_bar_personal_account_title)
            else -> null
        }

    @Composable
    private fun getCurrentRoute() = navController
        .currentBackStackEntryAsState().value?.destination?.route

    fun backPress() {
        navController.navigateUp()
    }
}

