package com.example.composecounters.ui.screens.ej05e

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.composecounters.R


@Composable
fun BloqueGlobal(globalCounter: Int, globalCounterReset: () -> Unit) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = stringResource(R.string.global) + ":")
            Text(modifier = Modifier.padding(horizontal = 10.dp), text = globalCounter.toString())
            IconoBorrar(onClick = globalCounterReset)
        }
    }
}
