package com.arkofdragons.mtgplayer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.zIndex
import com.arkofdragons.mtgplayer.components.Menu
import com.arkofdragons.mtgplayer.components.pages.Home
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        var contentPage by remember { mutableStateOf("Home") }

        Box {

            Menu(listOf("Home", "Settings"), onOptionChange = fun(selection: String) { contentPage = selection }, modifier = Modifier.zIndex(1000f))

            Column(
                modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer).safeContentPadding()
                    .fillMaxSize()
            ) {
                Home(contentPage == "Home")
            }
        }
    }
}