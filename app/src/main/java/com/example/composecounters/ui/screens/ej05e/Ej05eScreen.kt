package com.example.composecounters.ui.screens.ej05e

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.composecounters.R
import com.example.composecounters.ui.screens.START_COUNT_DEFAULT


@Composable
fun Ej05eScreen() {
    val (globalCounter, setGlobalCounter) = rememberSaveable { mutableStateOf(START_COUNT_DEFAULT) }
    BloqueDosContadoresYGlobal(globalCounter, setGlobalCounter)
}

@Composable
fun BloqueDosContadoresYGlobal(globalCounter: Int, setGlobalCounter: (Int) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        BloqueContadorD(
            nombreContador = stringResource(id = R.string.count1),
            accionExterna = { _, incremento ->
                setGlobalCounter(globalCounter + (incremento ?: 0)) // TODO
            })

        BloqueContadorD(
            nombreContador = stringResource(R.string.count2),
            accionExterna = { _, incremento ->
                setGlobalCounter(globalCounter + (incremento ?: 0)) // TODO
            })

        BloqueGlobal(
            globalCounter = globalCounter,
            globalCounterReset = { /*globalCounter = 0*/ }
        )
    }
}


@Composable
fun IconoBorrar(onClick: () -> Unit) {
    Icon(if (isSystemInDarkTheme()) Icons.Filled.Delete else Icons.Outlined.Delete,
        contentDescription = "Reiniciar",
        modifier = Modifier.clickable { onClick() })
}

