package com.arkofdragons.mtgplayer.ui.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import mtgplayer.composeapp.generated.resources.Res
import mtgplayer.composeapp.generated.resources.materialIconMenu
import org.jetbrains.compose.resources.painterResource

@Composable
fun Navigation(destinations: List<NavDestination>, onOptionChange: (String) -> Unit, modifier: Modifier = Modifier) {

    var showMenu by remember { mutableStateOf(false) }
    var selectedDestination by remember { mutableStateOf(0) }

    Box(modifier) {
        NavigationRail() {
            NavigationRailItem(
                selected = false,
                onClick = { showMenu = !showMenu },
                icon = { Icon(painterResource(Res.drawable.materialIconMenu), contentDescription = "Menu") },
                label = { "Menu".toString() }
            )

            destinations.forEachIndexed { index, destination ->
                AnimatedVisibility(showMenu, enter = expandHorizontally(), exit = shrinkHorizontally()) {
                    NavigationRailItem(
                        selected = selectedDestination == index,
                        onClick = {
                            selectedDestination = index
                            onOptionChange(destination.route)
                        },
                        icon = {
                            Icon(
                                painterResource(destination.icon),
                                contentDescription = destination.contentDescription
                            )
                        },
                        label = { destination.label }
                    )
                }
            }
        }
    }
}