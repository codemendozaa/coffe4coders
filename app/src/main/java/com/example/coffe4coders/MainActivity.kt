package com.example.coffe4coders

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coffe4coders.ui.screens.DeatailScreen
import com.example.coffe4coders.ui.screens.FeedScreens
import com.example.coffe4coders.ui.theme.Coffe4codersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { NavigationHost() }
    }

    @Composable
    fun NavigationHost() {
        val navController = rememberNavController()
        Coffe4codersTheme {
            Surface(color = MaterialTheme.colors.background) {
                NavHost(navController = navController, startDestination = "feed") {
                    composable(route = "feed") {
                        FeedScreens(navController)
                    }
                    composable(route = "detail") {
                        DeatailScreen()
                    }
                }
            }
        }
    }
}
