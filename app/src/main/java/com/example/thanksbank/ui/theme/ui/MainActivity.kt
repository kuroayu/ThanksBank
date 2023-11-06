package com.example.thanksbank.ui.theme.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.tooling.preview.Preview
import com.example.thanksbank.ui.theme.ThanksBankTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThanksBankTheme {
                val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setSystemBarsColor(color = Color.Black)
                }
                val navController = rememberNavController()
                Scaffold(
                    topBar = {
                        val currentBackStackEntry by navController.currentBackStackEntryAsState()
                        TopAppBar(
                            title = {/* タイトルを表示しない */},
                            navigationIcon = {
                                if (currentBackStackEntry?.destination?.route == "AddFriend") {
                                    IconButton(onClick = {
                                        navController.navigateUp()
                                    }) {
                                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                                    }
                                }
                            }
                        )
                    }
                ) { paddingValues ->
                    NavHost(
                        modifier = Modifier.padding(paddingValues),
                        navController = navController,
                        startDestination = "MainActivity"
                    ) {
                        composable("MainActivity") {
                            FriendListContent {
                                navController.navigate("AddFriend")
                            }
                        }
                        composable("AddFriend") {
                            AddFriendContent {
                                navController.navigateUp()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun DefaultPreview() {
    ThanksBankTheme {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setSystemBarsColor(color = Color.Black)
        }
        val navController = rememberNavController()
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("My App") },
                    navigationIcon = {
                        val currentBackStackEntry by navController.currentBackStackEntryAsState()
                        if (currentBackStackEntry?.destination?.route == "AddFriend") {
                            IconButton(onClick = {
                                navController.navigateUp()
                            }) {
                                Icon(Icons.Default.ArrowBack, contentDescription = null)
                            }
                        }
                    }
                )
            }
        ) { paddingValues ->
            NavHost(
                modifier = Modifier.padding(paddingValues),
                navController = navController,
                startDestination = "MainActivity"
            ) {
                composable("MainActivity") {
                    FriendListContent {
                        navController.navigate("AddFriend")
                    }
                }
                composable("AddFriend") {
                    AddFriendContent {
                        navController.navigateUp()
                    }
                }
            }
        }
    }
}