package com.example.crossmemo.ui.homepage

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose.CrossMemoTheme
import com.example.crossmemo.data.memo.Memo
import com.example.crossmemo.navigation.Screen // Import your Screen object
import com.example.crossmemo.ui.components.BriefMemoCard

@Composable
fun HomepageScreen(
    navController: NavController,
    viewModel: HomepageViewModel = hiltViewModel()
) {
    val memos by viewModel.memos.collectAsStateWithLifecycle()

    Scaffold(
        // containerColor = Color.Black.copy(alpha = 0.6f), // Consider removing or adjusting for M3
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.MemoEdit.route) // Use route from Screen object
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Create,
                    contentDescription = "Add new memo"
                )
            }
        },
    ) { innerPadding ->
        if (memos.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .consumeWindowInsets(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No memos yet. Tap the + button to create one!",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .consumeWindowInsets(innerPadding),
                contentPadding = innerPadding, // This already handles padding for items
                verticalArrangement = Arrangement.spacedBy(8.dp) // Adds space between items
            ) {
                items(memos, key = { memo -> memo.id }) { memo ->
                    BriefMemoCard(
                        title = memo.title,
                        content = memo.content // Consider showing a snippet or plain text version of HTML
                        // onClick = { navController.navigate(Screen.MemoEdit.route + "/${memo.id}") } // For editing
                    )
                }
            }
        }
    }
}


@Preview(name = "Light Mode", uiMode = Configuration.UI_MODE_NIGHT_NO, showSystemUi = true)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
fun HomepageScreenPreview() {
    CrossMemoTheme {
        // For preview, you might not have a real ViewModel. 
        // You can create a fake list of memos for the preview.
        HomepageScreen(navController = rememberNavController())
        // To make preview work better with ViewModel, you might need to pass a fake ViewModel
        // or mock its state for the preview if hiltViewModel() causes issues in preview.
    }
}
