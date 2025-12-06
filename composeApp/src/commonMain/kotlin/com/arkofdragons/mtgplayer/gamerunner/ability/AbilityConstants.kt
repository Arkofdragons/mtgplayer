package com.arkofdragons.mtgplayer.gamerunner.ability

enum class AbilityTarget {
    CREATURE,
    PLANESWALKER,
    PLAYER,
    ARTIFACT,
    ENCHANTMENT,
    SPELL,
    COUNTER
}

enum class AbilityType {
    ACTIVATED,
    TRIGGERED,
    MANA,
    STATIC
}