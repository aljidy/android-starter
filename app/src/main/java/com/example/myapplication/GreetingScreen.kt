package com.example.myapplication

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GreetingScreen(onNextButtonTap: (String) -> Unit) {
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        TopAppBar(
            title = {
                Text(stringResource(R.string.app_name))
            },
        )
    }) { innerPadding ->
        GreetingScreenContent(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) { onNextButtonTap("Pal") }
    }
}

@Composable
private fun GreetingScreenContent(
    modifier: Modifier = Modifier,
    onNextButtonTap: () -> Unit
) {
    Column(
        modifier = modifier,
    ) {
        Text(text = "Hello Android!")

        Spacer(modifier = Modifier.weight(1f))

        Button(onClick = { onNextButtonTap() }, modifier = Modifier.align(Alignment.End)) {
            Text("Next Screen")
        }
    }
}

@Preview(showBackground = true, apiLevel = 33) // Required otherwise text has render problem on 34+
@Composable
private fun GreetingScreenPreview() {
    MyApplicationTheme {
        val context = LocalContext.current

        GreetingScreenContent(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            onNextButtonTap = {
                Toast.makeText(context, "Button tapped", Toast.LENGTH_LONG).show()
                // TODO make this something that shows in interactive mode
            },
        )
    }
}
