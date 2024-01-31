package com.example.composecounters.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun VersionPFFPScreen() {

    var count1 by remember { mutableIntStateOf(0) }
    var count2 by remember { mutableIntStateOf(0) }
    var countG by remember { mutableIntStateOf(0) }

    var valueTF1 by rememberSaveable { mutableStateOf("") }

    Column(
        Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Contadores", style = MaterialTheme.typography.h2)
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Button(onClick = {
                    count1 += valueTF1.toInt()
                    countG += valueTF1.toInt()
                }) {
                    Text(text = "Contador 1 ($count1)")
                }
                Spacer(modifier = Modifier.width(6.dp))
                Text(text = "$count1")
                IconButton(onClick = { count1 = 0 }) {
                    Icon(
                        imageVector = Icons.Filled.Delete, contentDescription = "Borrar"
                    )
                }
            }
            OutlinedTextField(value = valueTF1, onValueChange = {valueTF1 = it}, label = { Text(text = "Incremento") })
        }
        Column {

        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Global: ($countG)")
            IconButton(onClick = { countG = 0 }) {
                Icon(
                    imageVector = Icons.Filled.Delete, contentDescription = "Borrar"
                )
            }
        }
    }

}