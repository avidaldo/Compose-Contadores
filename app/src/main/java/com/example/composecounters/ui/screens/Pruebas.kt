package com.example.composecounters.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.material.Button
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier


@Composable
fun Pruebas() {
    var text by rememberSaveable { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        //enabled = false,
        modifier = Modifier
            .clickable { text = "Clicked" },
//        colors = TextFieldDefaults.textFieldColors(
//            disabledTextColor = LocalContentColor.current.copy(LocalContentAlpha.current),
//            disabledLabelColor = MaterialTheme.colors.onSurface.copy(ContentAlpha.medium)
//        )
    )
//    Button(onClick = onClick) {
//                    Text(text = "Contador 1 ($count)")
//                }
//                Button(onClick = {
//                    onClick()
//                    count++
//                }) {
//                    Text(text = "Contador 1 ($count)")
//                }
}

