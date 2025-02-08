package com.example.crossmemo.ui.homepage

import android.content.res.Configuration
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose.CrossMemoTheme
import com.example.crossmemo.data.Memo
import com.example.crossmemo.ui.components.BriefMemoCard

@Composable
fun HomepageScreen(navController: NavController) {
    val memos : List<Memo> = emptyList()

    Scaffold(
        containerColor = Color.Black.copy(alpha = 0.6f),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Default.Create,
                    contentDescription = "Add new memo"
                )
            }
        },
        //contentWindowInsets = WindowInsets(top = 0)
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.consumeWindowInsets(innerPadding),
            contentPadding = innerPadding
        ) {
            repeat(50) {
                item {
                    BriefMemoCard(
                        title = "title",
                        content = "content"
                    )
                }
            }
            item {
                BriefMemoCard(
                    title = "title",
                    content = "content"
                )
            }
            items(memos) { memo ->
                BriefMemoCard(
                    title = "title",
                    content = "content"
                )
            }
        }
    }
}


@Preview(name = "Light Mode", uiMode = Configuration.UI_MODE_NIGHT_NO, showSystemUi = true)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
fun HomepageScreenPreview() {
    CrossMemoTheme {
        HomepageScreen(navController = rememberNavController())
    }
}