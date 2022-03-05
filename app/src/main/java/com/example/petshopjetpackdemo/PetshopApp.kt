package com.example.petshopjetpackdemo

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.petshopjetpackdemo.ui.components.BottomNavigationBar
import com.example.petshopjetpackdemo.ui.components.PetshopScaffold
import com.example.petshopjetpackdemo.ui.components.TopBar
import com.example.petshopjetpackdemo.ui.screen.Navigation
import com.example.petshopjetpackdemo.ui.theme.PetshopJetpackDemoTheme
import com.google.accompanist.insets.ProvideWindowInsets

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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PetshopApp()
}
