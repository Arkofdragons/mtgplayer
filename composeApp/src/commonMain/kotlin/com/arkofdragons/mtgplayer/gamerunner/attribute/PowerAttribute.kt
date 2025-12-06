package com.arkofdragons.mtgplayer.gamerunner.attribute

import kotlinx.serialization.Serializable

@Serializable
class PowerAttribute(override var value: IntegerDynamicValue) : Attribute<IntegerDynamicValue> {

    constructor(value: Int) : this(IntegerDynamicValue(value))

    override fun getAttributeType(): AttributeType {
        return AttributeType.POWER
    }
}