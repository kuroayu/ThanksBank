package com.example.thanksbank.ui.theme.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.thanksbank.R
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThanksBankTheme {
                AppScreen()
            }
        }
    }
}

@Composable
fun AppScreen() {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(color = Color.Black)
    }
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopBar(
                navController = navController,
                onAddFriendClick = {
                    navController.navigate("AddFriend")
                }
            )
        }
    ) { paddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            startDestination = "FriendList"
        ) {
            composable("FriendList") {
                FriendListContent(
                    toThanksList = {
                        navController.navigate("ThanksList")
                    }
                )
            }
            composable("AddFriend") {
                AddFriendContent {
                    navController.navigateUp()
                }
            }
            composable("ThanksList") {
                ThanksListContent(
                    toAddThanks = {
                        navController.navigate("AddThanks")
                    }
                )
            }
            composable("AddThanks") {
                AddThanksContent {
                    navController.navigateUp()
                }
            }
        }
    }
}

@Composable
fun TopBar(navController: NavController, onAddFriendClick: () -> Unit) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()

    TopAppBar(
        title = {/* タイトルを表示しない */ },
        navigationIcon = {
            if (currentBackStackEntry?.destination?.route != "FriendList") {
                IconButton(onClick = {
                    navController.navigateUp()
                }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = null)
                }
            }
        },
        actions = {
            if (currentBackStackEntry?.destination?.route == "FriendList") {
                Button(
                    modifier = Modifier
                        .padding(8.dp)
                        .size(100.dp, 50.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.secondary,
                        contentColor = MaterialTheme.colors.onSecondary
                    ),
                    onClick = {
                        onAddFriendClick()
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.button_add_friend)
                    )
                }
            }
        }
    )
}

@Composable
@Preview(showBackground = true)
fun DefaultPreview() {
    ThanksBankTheme {
        AppScreen()
    }
}
