package com.arkofdragons.mtgplayer.ui.navigation

import mtgplayer.composeapp.generated.resources.Res
import mtgplayer.composeapp.generated.resources.materialIconHome
import mtgplayer.composeapp.generated.resources.materialIconSettings
import org.jetbrains.compose.resources.DrawableResource

data class NavDestination(
    val route: String,
    val label: String,
    val icon: DrawableResource,
    val contentDescription: String = ""
) {
    companion object {
        val mainNav: List<NavDestination> = listOf(
            NavDestination("home", "Home", Res.drawable.materialIconHome),
            NavDestination("settings", "Settings", Res.drawable.materialIconSettings)
        )
    }
}