package com.example.crossmemo.navigation

sealed class Screen(val route: String) {
    data object Home: Screen(route = "home_screen")
    data object MemoEdit: Screen(route = "memo_edit_screen")
}