package com.arkofdragons.mtgplayer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.arkofdragons.mtgplayer.components.Menu
import com.arkofdragons.mtgplayer.components.pages.Home
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        var contentPage by remember { mutableStateOf("Home") }

        Row {

            Menu(listOf("Home", "Settings"), onOptionChange = fun(selection: String) { contentPage = selection })

            Column(
                modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer).safeContentPadding()
                    .fillMaxSize()
            ) {
                Home(contentPage == "Home")
            }
        }
    }
}