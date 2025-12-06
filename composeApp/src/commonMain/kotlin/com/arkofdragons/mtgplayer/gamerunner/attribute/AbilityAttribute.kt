package com.arkofdragons.mtgplayer.gamerunner.attribute

import com.arkofdragons.mtgplayer.gamerunner.ability.Ability
import kotlinx.serialization.Serializable

@Serializable
class AbilityAttribute(override var value: Ability) : Attribute<Ability> {
    override fun getAttributeType(): AttributeType {
        return AttributeType.ABILITY
    }
}