package com.example.petshopjetpackdemo.ui.screen

sealed class Screen(val route: String) {

    object ProfileScreen : Screen("profile")

    object ProfileSectionScreen : Screen("profile_section")

    fun withArgs(vararg args: String): String =
        buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
}