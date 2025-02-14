package com.example.crossmemo.ui.memoEditPage

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.CrossMemoTheme
import com.mohamedrejeb.richeditor.model.rememberRichTextState
import com.mohamedrejeb.richeditor.ui.material3.RichTextEditor

@Composable
fun MemoEditScreen() {
    val state = rememberRichTextState()
    Scaffold { innerPadding ->
        RichTextEditor(
            state = state,
            modifier = Modifier.padding(innerPadding).fillMaxSize()
        )
    }
}


@Preview(name = "Light Mode", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MemoEditScreenPreview() {
    CrossMemoTheme {
        MemoEditScreen()
    }
}