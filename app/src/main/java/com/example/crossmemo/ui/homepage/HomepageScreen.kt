package com.example.crossmemo.ui.homepage

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose.CrossMemoTheme

@Composable
fun HomepageScreen(navController: NavController) {
}


@Preview(name = "Light Mode", uiMode = Configuration.UI_MODE_NIGHT_NO, showSystemUi = true)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
fun HomepageScreenPreview() {
    CrossMemoTheme {
        HomepageScreen(navController = rememberNavController())
    }
}