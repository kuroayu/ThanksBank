package com.example.thanksbank.ui.theme.ui


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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.thanksbank.ui.theme.ThanksBankApplication
import com.example.thanksbank.ui.theme.model.ThanksUiState
import com.example.thanksbank.ui.theme.theme.ThanksBankTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@Composable
fun ThanksListContent(toAddThanks: () -> Unit, friendId: Int?) {
    val thanksListViewModel = viewModel {
        val application =
            get(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY) as ThanksBankApplication
        ThanksListViewModel(application.thanksRepository)
    }

    if (friendId != null) {
        thanksListViewModel.init(friendId)
    }

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
            ThanksList(thanksListViewModel)
        }
    }
}

@Composable
fun ThanksList(thanksListViewModel: ThanksListViewModel) {
    val thanksData by thanksListViewModel.thanksData.collectAsState()
    LazyColumn(
        content = {
            items(thanksData) { data ->
                ThanksListItem(
                    friendData = data
                )
            }
        }
    )
}

//ここスペーサー抜いて上のマージン見ればすっきりしそう
@Composable
fun ThanksListItem(friendData: ThanksUiState) {
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
            text = dateConverter(friendData.date)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            modifier = Modifier
                .padding(start = 10.dp),
            color = MaterialTheme.colors.onSecondary,
            text = friendData.message,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(4.dp))
    }
}

fun dateConverter(date: Long): String {
    val convertedDate = Date(date)

    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.JAPAN)
    return dateFormat.format(convertedDate)
}


@Preview
@Composable
fun PreviewThanksList() {
    ThanksBankTheme {
        // ThanksListContent({}, backStackEntry.arguments?.getString("userId"))
    }
}