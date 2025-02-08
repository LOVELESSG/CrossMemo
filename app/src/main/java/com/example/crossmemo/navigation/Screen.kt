package com.example.crossmemo.navigation

sealed class Screen(val route: String) {
    data object Home: Screen(route = "home_screen")
}