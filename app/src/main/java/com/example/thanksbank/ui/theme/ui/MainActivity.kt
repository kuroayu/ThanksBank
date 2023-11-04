package com.example.thanksbank.ui.theme.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.tooling.preview.Preview
import com.example.thanksbank.ui.theme.ThanksBankTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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

                NavHost(navController = navController, startDestination = "MainActivity") {
                    composable("MainActivity") {
                        FriendListContent{
                            navController.navigate("AddFriend")
                        }
                    }
                    composable("AddFriend") {
                        AddFriendContent()
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

        NavHost(navController = navController, startDestination = "MainActivity") {
            composable("MainActivity") {
                FriendListContent{
                    navController.navigate("AddFriend")
                }
            }
            composable("AddFriend") {
                AddFriendContent()
            }
        }
    }
}