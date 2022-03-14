package me.krasnova.common.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import me.krasnova.common.ui.screen.profile.ProfileScreen
import me.krasnova.common.ui.screen.profileSection.ProfileSectionScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.ProfileScreen.route
    ) {
        composable(route = Screen.ProfileScreen.route) { from ->
            ProfileScreen(navController, from)
        }
        composable(
            route = "${Screen.ProfileSectionScreen.route}/{$ProfileSectionTitleKey}",
            arguments = listOf(
                navArgument(name = ProfileSectionTitleKey) { type = NavType.StringType }
            )
        ) {
            ProfileSectionScreen()
        }
    }
}

const val ProfileSectionTitleKey = "profileSectionTitle"