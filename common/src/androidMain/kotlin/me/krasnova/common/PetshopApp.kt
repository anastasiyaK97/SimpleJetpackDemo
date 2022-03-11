package me.krasnova.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.ProvideWindowInsets
import me.krasnova.common.ui.components.BottomNavigationBar
import me.krasnova.common.ui.components.PetshopScaffold
import me.krasnova.common.ui.components.TopBar
import me.krasnova.common.ui.screen.Navigation
import me.krasnova.common.ui.theme.PetshopJetpackDemoTheme

@Composable
fun PetshopApp() {
    ProvideWindowInsets {
        PetshopJetpackDemoTheme {
            val appState = rememberPetshopAppState()
            PetshopScaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = {
                    TopBar(
                        title = appState.toolbarTitle ?: "",
                        backAction = { appState.backPress() },
                        previousTitle = appState.toolbarPreviousTitle
                    )
                },
                bottomBar = {
                    BottomNavigationBar(
                        tabs = appState.bottomBarTabs
                    )
                }
            ) {
                Navigation(navController = appState.navController)
            }
        }
   }
}
