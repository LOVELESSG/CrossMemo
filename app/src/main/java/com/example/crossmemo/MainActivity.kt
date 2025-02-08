package com.example.crossmemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.compose.CrossMemoTheme
import com.example.crossmemo.navigation.Screen
import com.example.crossmemo.navigation.navGraph.SetupNavGraph
import com.example.crossmemo.ui.homepage.HomepageScreen

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CrossMemoTheme {
                navController = rememberNavController()

                SetupNavGraph(
                    navController = navController,
                    startScreen = Screen.Home.route
                )
            }
        }
    }
}