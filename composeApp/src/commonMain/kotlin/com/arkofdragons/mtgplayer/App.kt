package com.arkofdragons.mtgplayer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.zIndex
import com.arkofdragons.mtgplayer.ui.navigation.NavDestination
import com.arkofdragons.mtgplayer.ui.navigation.Navigation
import com.arkofdragons.mtgplayer.ui.pages.Home
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        var contentPage by remember { mutableStateOf("home") }

        Box {

            Navigation(
                NavDestination.mainNav,
                onOptionChange = fun(selection: String) {
                    contentPage = selection
                    println("Content page updated to $selection")
                },
                modifier = Modifier.zIndex(1000f)
            )

            Column(
                modifier = Modifier
                    .safeContentPadding()
                    .fillMaxSize()
            ) {
                Home(contentPage == "home")
            }
        }
    }
}