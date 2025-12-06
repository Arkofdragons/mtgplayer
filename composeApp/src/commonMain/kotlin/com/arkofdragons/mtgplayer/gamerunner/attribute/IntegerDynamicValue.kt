package com.arkofdragons.mtgplayer.gamerunner.attribute

import kotlinx.serialization.Serializable

@Serializable
class IntegerDynamicValue(
    private var _value: Int,
    var isStatic: Boolean = true
) {

    var value: Int
        get() {
            if (isStatic) return _value
            return 0 // TODO: variable value based on hooks
        }
        set(newValue) {
            _value = newValue
        }

    operator fun plus(other: Int): Int {
        return value + other
    }

    operator fun Int.plus(other: IntegerDynamicValue): Int {
        return other.value + this
    }

    operator fun plus(other: IntegerDynamicValue): Int {
        return value + other.value
    }
}