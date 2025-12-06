package com.arkofdragons.mtgplayer.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SuddenVisibility(
    visible: Boolean,
    label: String = "SuddenVisibility",
    modifier: Modifier = Modifier,
    content: @Composable() AnimatedVisibilityScope.() -> Unit,
) {

    AnimatedVisibility(
        visible,
        modifier,
        enter = EnterTransition.None,
        exit = ExitTransition.None,
        label,
        content,
    )
}