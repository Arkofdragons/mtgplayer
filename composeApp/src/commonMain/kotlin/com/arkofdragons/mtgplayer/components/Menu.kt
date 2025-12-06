package com.arkofdragons.mtgplayer.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import mtgplayer.composeapp.generated.resources.Res
import mtgplayer.composeapp.generated.resources.materialIconMenu
import org.jetbrains.compose.resources.painterResource

@Composable
fun Menu(options: List<String>, onOptionChange: (String) -> Unit, modifier: Modifier = Modifier) {

    var showMenu by remember { mutableStateOf(false) }

    Column(modifier) {
        Button(
            onClick = { showMenu = !showMenu },
            shape = CircleShape,
            modifier = Modifier.size(40.dp),
            contentPadding = PaddingValues(0.dp)
        ) {
            Image(
                painterResource(Res.drawable.materialIconMenu),
                contentDescription = "Menu Icon"
            )
        }

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
    }
}