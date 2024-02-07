package com.example.composecounters.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


@Composable
fun VersionPFFPSimpleScreen() {
    val context = LocalContext.current


    Column(
        Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Contadores", style = MaterialTheme.typography.h2)


        var countG by remember { mutableIntStateOf(0) }

        Bloque(
            onClick = { incremento ->
                countG += incremento
            })
        Bloque({
            countG += it
        })
        BloqueG(countG)


    }
}


//TODO: sería interesante hacer un ejemplo en java con el paso de parámetro que recibe un parámetro,
// para entender la capa inferior

@Composable
private fun Bloque(onClick: (Int) -> Unit, modifier: Modifier = Modifier) {
    var count by remember { mutableIntStateOf(0) }
    var value by remember { mutableStateOf("") }
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = {
                val inc = value.toIntOrNull() ?: 1
                onClick(inc)
                count += inc
            }) {
                Text(text = "Contador 1 ($count)")
            }
            Spacer(modifier = Modifier.width(6.dp))
            Text(text = "$count")
        }

        OutlinedTextField(value = value, onValueChange = { value = it })
    }
}


@Composable
private fun BloqueG(countG: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Global: ($countG)")
    }
}