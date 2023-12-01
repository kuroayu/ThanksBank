package com.example.thanksbank.ui.theme.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.thanksbank.R
import com.example.thanksbank.ui.theme.ThanksBankApplication
import com.example.thanksbank.ui.theme.theme.ThanksBankTheme


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AddFriendContent(
    toFriendList: () -> Unit
) {
    ThanksBankTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.secondary
        ) {
            val addFriendViewModel = viewModel {
                val application =
                    get(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY) as ThanksBankApplication
                AddFriendViewModel(application.friendRepository)
            }
            var friendName by rememberSaveable {
                mutableStateOf("")
            }
            val keyboardController = LocalSoftwareKeyboardController.current
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 50.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = friendName,
                    onValueChange = {
                        if (friendName.length <= 10) {
                            friendName = it
                        }
                    },
                    label = { Text(stringResource(id = R.string.label_input_friend_name)) },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                        }
                    )
                )
                Button(
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .size(100.dp, 50.dp),
                    onClick = {
                        addFriendViewModel.insertFriendData(
                            friendName
                        )
                        toFriendList()
                    }
                ) {
                    Text(
                        color = MaterialTheme.colors.secondary,
                        text = stringResource(id = R.string.button_save_friend_name)
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewAddFriend() {
    ThanksBankTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.secondary
        ) {
            AddFriendContent(toFriendList = {})
        }
    }
}


