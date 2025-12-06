package com.arkofdragons.mtgplayer.gamerunner.ability

import kotlinx.serialization.Serializable

@Serializable
class Ability {

    val abilityTypes: MutableList<AbilityType> = mutableListOf()
}
