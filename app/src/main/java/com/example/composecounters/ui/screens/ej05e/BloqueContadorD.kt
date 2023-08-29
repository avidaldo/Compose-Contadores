package com.example.composecounters.ui.screens.ej05e

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.example.composecounters.R
import com.example.composecounters.ui.screens.INCREMENT_DEFAULT
import com.example.composecounters.ui.screens.START_COUNT_DEFAULT


@Composable
fun BloqueContadorD(
    nombreContador: String = stringResource(R.string.count),
    accionExterna: (Int, Int?) -> Unit,
) {
    var numCounter: Int by rememberSaveable { mutableStateOf(START_COUNT_DEFAULT) }
    var incremento: Int? by rememberSaveable { mutableStateOf(INCREMENT_DEFAULT) }

    BloqueContadorDSinEstado(
        nombreContador = nombreContador,
        cuenta = numCounter,
        cambiaCuenta = { numCounter = it },
        incremento = incremento,
        cambiaIncremento = { incremento = it },
        accionExterna = accionExterna,
    )

}

@Composable
fun BloqueContadorDSinEstado(
    nombreContador: String,
    cuenta: Int,
    cambiaCuenta: (Int) -> Unit,
    incremento: Int?,
    cambiaIncremento: (Int?) -> Unit,
    accionExterna: (Int, Int?) -> Unit,
) {
        Column {
            val focusManager = LocalFocusManager.current

        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = {
                focusManager.clearFocus() // Sin esto no pierde el foco del TextField (por eso queda el teclado)
                cambiaCuenta(cuenta + incremento!!)
                accionExterna(cuenta, incremento) // TODO
            }) {
                Text(text = "$nombreContador ($cuenta)")
            }
            Text(modifier = Modifier.padding(horizontal = 10.dp), text = cuenta.toString())
            IconoBorrar(onClick = { cambiaCuenta(START_COUNT_DEFAULT) })
        }
        Row(verticalAlignment = Alignment.Bottom) {
            Text(text = stringResource(R.string.increment))
            BasicTextField(
                value = incremento?.toString() ?: "",
                onValueChange = {
                    if (it.isNotBlank() && it.isDigitsOnly()) { // TODO
                        cambiaIncremento(it.toIntOrNull())
                    }
                },
                modifier = Modifier
                    .onFocusChanged { if (it.hasFocus) cambiaIncremento(null) },  // TODO
                //.focusRequester(focusRequester),  // TODO
                singleLine = true,
                textStyle = TextStyle(
                    textAlign = TextAlign.End,
                    color = MaterialTheme.colors.onSurface
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
              //  keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                decorationBox = {
                    Row(
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .width(25.dp)
                            .aspectRatio(1f)
                            .border(
                                width = 1.dp,
                                color = MaterialTheme.colors.primary,
                                shape = RoundedCornerShape(size = 5.dp)
                            )
                            .padding(horizontal = 5.dp),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        it
                    }
                }
            )
        }
    }
}