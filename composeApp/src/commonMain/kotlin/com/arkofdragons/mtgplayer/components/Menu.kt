package com.arkofdragons.mtgplayer.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun Menu(options: List<String>, onOptionChange: (String) -> Unit, modifier: Modifier = Modifier) {

      var showMenu by remember { mutableStateOf(true) }

    Column(verticalArrangement = Arrangement.SpaceBetween, modifier = modifier) {
        AnimatedVisibility(showMenu, enter = expandHorizontally(), exit = shrinkHorizontally()) {

            Column(
                verticalArrangement = Arrangement.Top,
            ) {
                for (option in options) {
                    Button(onClick = { onOptionChange.invoke(option) }) {
                        Text(option)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(onClick = { showMenu = !showMenu }) {
            Text("Menu")
        }
    }
}