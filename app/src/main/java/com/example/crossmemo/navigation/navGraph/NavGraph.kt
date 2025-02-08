package com.example.crossmemo.navigation.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.crossmemo.navigation.Screen
import com.example.crossmemo.ui.homepage.HomepageScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startScreen: String
) {
    NavHost(
        navController = navController,
        startDestination = startScreen
    ) {
        composable(
            route = Screen.Home.route
        ) {
            HomepageScreen(
                navController = navController
            )
        }
    }
}