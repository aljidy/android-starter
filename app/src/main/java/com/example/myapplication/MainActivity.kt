package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.serialization.Serializable

@Serializable
object Greeting

@Serializable
data class Detail(val name: String)

const val GREETING_NAME: String = "Friend"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            MyApplicationTheme {
                NavHost(navController = navController, startDestination = Greeting) {
                    composable<Greeting> {
                        GreetingScreen {
                            navController.navigate(route = Detail(name = GREETING_NAME))
                        }
                    }

                    composable<Detail> { backStackEntry ->
                        val detail: Detail = backStackEntry.toRoute()
                        DetailScreen(
                            name = detail.name,
                            onNavigateBackTapped = { navController.popBackStack() },
                        )
                    }
                }
            }
        }
    }
}
