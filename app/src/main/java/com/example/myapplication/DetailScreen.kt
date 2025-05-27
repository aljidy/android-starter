package com.example.myapplication

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun DetailScreen(
    onNavigateBackTapped: () -> Unit,
    name: String,
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier =
                Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
        ) {
            IconButton(onClick = onNavigateBackTapped, modifier = Modifier.align(Alignment.Start)) {
                Icon(
                    tint = MaterialTheme.colorScheme.primary,
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = "Back to Greeting Screen",
                )
            }

            Row(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = "Hello again $name!",
                    modifier = Modifier.align(Alignment.CenterVertically).fillMaxWidth(),
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailScreenPreview() {
    MyApplicationTheme {
        val context = LocalContext.current

        DetailScreen({
            Toast.makeText(context, "Back Tapped", Toast.LENGTH_LONG).show()
        }, "Pal")
    }
}
