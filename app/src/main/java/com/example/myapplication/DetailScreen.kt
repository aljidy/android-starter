package com.example.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    onNavigateBackTapped: () -> Unit,
    name: String,
) {
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        TopAppBar(
            title = {

            },
            navigationIcon = {
                IconButton(
                    onClick = onNavigateBackTapped,
                    modifier = Modifier.testTag("BackButton")
                ) {
                    Icon(
                        tint = MaterialTheme.colorScheme.primary,
                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                        contentDescription = "Back to Greeting Screen",
                    )
                }
            }
        )
    }) { innerPadding ->
        DetailScreenContent(Modifier.padding(innerPadding), name)
    }
}


@Composable
fun DetailScreenContent(
    modifier: Modifier = Modifier,
    name: String
) {
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
            Row(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = "Hello again $name!",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                )
            }

    }
}


@Preview(showBackground = true, apiLevel = 33) // Required otherwise text has render problem on 34+
@Composable
private fun DetailScreenPreview() {
    MyApplicationTheme {
        DetailScreenContent(name = "Pal", modifier = Modifier.fillMaxSize())
    }
}
