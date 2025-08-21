package com.example.crossmemo.ui.memoEditPage

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel // Added for ViewModel
import androidx.navigation.NavController // Added for navigation
import com.example.compose.CrossMemoTheme
import com.example.crossmemo.ui.components.EditorControlsBar
// Assuming you will create this ViewModel
// import com.example.crossmemo.ui.memoEditPage.MemoEditViewModel
import com.mohamedrejeb.richeditor.model.rememberRichTextState
import com.mohamedrejeb.richeditor.ui.material3.RichTextEditor
import com.mohamedrejeb.richeditor.ui.material3.OutlinedRichTextEditor // If you want rich text for title too, else use OutlinedTextField

@OptIn(ExperimentalMaterial3Api::class) // Added for Scaffold, TopAppBar, etc.
@Composable
fun MemoEditScreen(
    navController: NavController, // Added NavController
    memoEditViewModel: MemoEditViewModel = hiltViewModel() // Instantiate your ViewModel here
) {
    val richTextState = rememberRichTextState()
    var title by remember { mutableStateOf("") } // Added state for title

    val titleSize = MaterialTheme.typography.displaySmall.fontSize
    val subtitleSize = MaterialTheme.typography.titleLarge.fontSize

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("New Memo") } // Or "Edit Memo" if applicable
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                val contentHtml = richTextState.toHtml()
                if (title.isNotBlank() && contentHtml.isNotBlank()) {
                    // (memoEditViewModel as? MemoEditViewModel)?.saveMemo(0, title, contentHtml) // Assuming new memo, pass id 0 or generate properly
                    // Log.d("MemoEditScreen", "Save Clicked: Title: $title, Content: $contentHtml") // For debugging
                    memoEditViewModel.saveMemo(title = title, contentHtml = contentHtml, existingMemoId = 0L)
                    navController.popBackStack() // Navigate back
                } else {
                    // Optionally: show a Snackbar or Toast if fields are empty
                    Log.d("MemoEditScreen", "Title or content is blank")
                }
            }) {
                Icon(Icons.Filled.Done, contentDescription = "Save Memo")
            }
        },
        bottomBar = {
            Surface(
                modifier = Modifier
                    .navigationBarsPadding()
                    .imePadding()
            ) {
                EditorControlsBar(
                    state = richTextState,
                    onBoldClick = {
                        richTextState.toggleSpanStyle(SpanStyle(fontWeight = FontWeight.Bold))
                    },
                    onItalicClick = {
                        richTextState.toggleSpanStyle(SpanStyle(fontStyle = FontStyle.Italic))
                    },
                    onUnderlineClick = {
                        richTextState.toggleSpanStyle(SpanStyle(textDecoration = TextDecoration.Underline))
                    },
                    onTitleClick = {
                        richTextState.toggleSpanStyle(SpanStyle(fontSize = titleSize))
                    },
                    onSubtitleClick = {
                        richTextState.toggleSpanStyle(SpanStyle(fontSize = subtitleSize))
                    },
                    onTextColorClick = {
                        // Consider making color selection more dynamic
                        richTextState.toggleSpanStyle(SpanStyle(color = Color.Red))
                    },
                    onStartAlignClick = {
                        richTextState.addParagraphStyle(ParagraphStyle(textAlign = TextAlign.Start))
                    },
                    onEndAlignClick = {
                        richTextState.addParagraphStyle(ParagraphStyle(textAlign = TextAlign.End))
                    },
                    onCenterAlignClick = {
                        richTextState.addParagraphStyle(ParagraphStyle(textAlign = TextAlign.Center))
                    },
                    onExportClick = {
                        Log.d("Editor", richTextState.toHtml())
                    }
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp) // Add some horizontal padding
                .imePadding(), // Handles keyboard overlaps
            verticalArrangement = Arrangement.spacedBy(8.dp), // Spacing between title and editor
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField( // Added TextField for Title
                value = title,
                onValueChange = { title = it },
                label = { Text("Memo Title") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                textStyle = MaterialTheme.typography.titleLarge // M3 Title Style
            )

            RichTextEditor(
                state = richTextState,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // Ensure editor takes available space
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(name = "Light Mode", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MemoEditScreenPreview() {
    CrossMemoTheme {
        // Preview won't work with NavController directly,
        // You might need a fake NavController for preview if interactions are needed.
        // For now, rendering without NavController or ViewModel interaction:
        val richTextState = rememberRichTextState()
        var title by remember { mutableStateOf("Preview Title") }

        Scaffold(
            topBar = {
                TopAppBar(title = { Text("New Memo Preview") })
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { }) {
                    Icon(Icons.Filled.Done, contentDescription = "Save Memo")
                }
            },
            bottomBar = {
                Surface(
                    modifier = Modifier
                        .navigationBarsPadding()
                        .imePadding()
                ) {
                    EditorControlsBar(
                        state = richTextState, onExportClick = {},
                        modifier = Modifier,
                        onBoldClick = {  },
                        onItalicClick = {  },
                        onUnderlineClick = { },
                        onTitleClick = {  },
                        onSubtitleClick = {  },
                        onTextColorClick = {  },
                        onStartAlignClick = {  },
                        onEndAlignClick = {  },
                        onCenterAlignClick = {  }
                    ) // Simplified for preview
                }
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp)
                    .imePadding(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Memo Title") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    textStyle = MaterialTheme.typography.titleLarge
                )
                RichTextEditor(
                    state = richTextState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
            }
        }
    }
}
