package com.arkofdragons.mtgplayer.gamerunner.attribute

import com.arkofdragons.mtgplayer.gamerunner.GameObject
import kotlinx.serialization.Serializable

@Serializable
sealed interface Attribute<T> {

    fun getAttributeType(): AttributeType

    var value: T

    fun addTo(gameObject: GameObject) {
        gameObject.addAttribute(this)
    }
}