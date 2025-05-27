package com.example.myapplication

 import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun GreetingScreen(onNextButtonTap: () -> Unit) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier =
                Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
        ) {
            Text(text = "Hello Android!")

            Spacer(modifier = Modifier.weight(1f))

            Button(onClick = onNextButtonTap, modifier = Modifier.align(Alignment.End)) {
                Text("Next Screen")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GreetingScreenPreview() {
    MyApplicationTheme {
        val context = LocalContext.current

        GreetingScreen {
            Toast.makeText(context, "Button tapped", Toast.LENGTH_LONG).show()
            // TODO make this something that shows in interactive mode
        }
    }
}
