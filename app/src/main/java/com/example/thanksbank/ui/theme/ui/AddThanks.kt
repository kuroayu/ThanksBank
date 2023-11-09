package com.example.thanksbank.ui.theme.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thanksbank.ui.theme.ThanksBankTheme

@Composable
fun AddThanksContent(toThanksList: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
    ) {
        val textState = remember { mutableStateOf(TextFieldValue()) }
        Text(
            modifier = Modifier.padding(16.dp),
            color = MaterialTheme.colors.onSecondary,
            text = "USER NAME"
        )
        TextField(
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
                .padding(16.dp)
                .background(MaterialTheme.colors.secondary, shape = RoundedCornerShape(3.dp)),
            value = textState.value,
            onValueChange = {
                textState.value = it
            }

        )
        Button(
            modifier = Modifier
                .padding(top = 30.dp)
                .size(100.dp, 50.dp)
                .align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
            onClick = { toThanksList() }) {
            Text(text = "保存")
        }
    }
}

@Preview
@Composable
fun PreviewAddThanks() {
    ThanksBankTheme {
        AddThanksContent{}
    }
}