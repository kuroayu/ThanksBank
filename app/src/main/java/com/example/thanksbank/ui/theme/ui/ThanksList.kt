package com.example.thanksbank.ui.theme.ui


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thanksbank.ui.theme.theme.ThanksBankTheme

data class FriendsData(val date: String, val msg: String)

@Composable
fun ThanksListContent(toAddThanks: () -> Unit, friendId: Int?) {
    
    Scaffold(
        backgroundColor = MaterialTheme.colors.primary,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { toAddThanks() }
            ) {
                Icon(Icons.Filled.Edit, contentDescription = "変更")
            }
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            ThanksList()
        }
    }
}


@Composable
fun ThanksList() {
    val friendListData = listOf(
        FriendsData(
            "2023.09.09",
            "Thanks！Thanks！Thanks！Thanks！Thanks！Thanks！Thanks！Thanks！Thanks！Thanks！Thanks！"
        ),
        FriendsData(
            "2023.10.10", "Another message"
        )
    )
    LazyColumn {
        items(friendListData) { item ->
            ThanksListItem(item)
        }
    }
}

@Composable
fun ThanksListItem(friendList: FriendsData) {
    Column(
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colors.secondary, shape = RoundedCornerShape(3.dp))
    ) {
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            modifier = Modifier
                .padding(start = 5.dp),
            color = MaterialTheme.colors.onSecondary,
            text = friendList.date
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            modifier = Modifier
                .padding(start = 10.dp),
            color = MaterialTheme.colors.onSecondary,
            text = friendList.msg,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(4.dp))
    }

}


@Preview
@Composable
fun PreviewThanksList() {
    ThanksBankTheme {
       // ThanksListContent({}, backStackEntry.arguments?.getString("userId"))
    }
}