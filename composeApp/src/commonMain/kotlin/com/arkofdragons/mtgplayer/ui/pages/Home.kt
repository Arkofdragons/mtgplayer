package com.arkofdragons.mtgplayer.ui.pages

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkofdragons.mtgplayer.Greeting
import com.arkofdragons.mtgplayer.cardparser.ParseCards
import com.arkofdragons.mtgplayer.gamerunner.testGame
import com.arkofdragons.mtgplayer.ui.element.SuddenVisibility
import mtgplayer.composeapp.generated.resources.Res
import mtgplayer.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource

@Composable
fun Home(visible: Boolean = false, modifier: Modifier = Modifier) {
    SuddenVisibility(
        visible = visible,
        modifier = modifier,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            var showLogo by remember { mutableStateOf(false) }
            Button(onClick = { showLogo = !showLogo }) {
                Text("Click me!")
            }

            Button(onClick = { ParseCards() }) {
                Text("Parse")
            }

            Button(onClick = { testGame() }) {
                Text("Test Game")
            }

            AnimatedVisibility(showLogo) {
                val greeting = remember { Greeting().greet() }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }

    println("Home rendered")
}