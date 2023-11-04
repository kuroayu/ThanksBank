package com.example.thanksbank.ui.theme.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thanksbank.ui.theme.ThanksBankTheme

class AddFriendActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThanksBankTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.primary
                ) {
                    AddFriendContent()
                }
            }
        }
    }
}
@Composable
fun AddFriendContent() {
    // シンプルなテキストを表示する例
    Text(
        text = "Hello, this is the AddFriendActivity!",
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        color = Color.Black
    )
}
//
//@Composable
//fun Test() {
//    Column(
//        modifier = Modifier.fillMaxSize()
//    ) {
//        Box(
//            modifier = Modifier
//
//                .padding(50.dp)
//                .background(Color.White, shape = RoundedCornerShape(2.dp))
//                .padding(5.dp)
//        ) {
//            Text(
//                color = MaterialTheme.colors.primary,
//                text = "Right-Aligned Text",
//                modifier = Modifier
//                    .align(Alignment.TopEnd)
//                    .padding(8.dp)
//            )
//        }
//    }
//}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ThanksBankTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.primary
        ) {
            AddFriendContent()
        }
    }
}