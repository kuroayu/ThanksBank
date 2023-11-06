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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thanksbank.R
import com.example.thanksbank.ui.theme.ThanksBankTheme


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AddFriendContent(toFriendList: () -> Unit) {
    ThanksBankTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.secondary
        ) {
            val textState = remember { mutableStateOf(TextFieldValue()) }
            val keyboardController = LocalSoftwareKeyboardController.current
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 50.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = textState.value,
                    onValueChange = {
                        if (it.text.length <= 10) {
                            textState.value = it
                        }
                    },
                    label = { Text("FriendName(10文字以内)") },
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
                    onClick = { toFriendList() }) {
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
            AddFriendContent {

            }
        }
    }
}


