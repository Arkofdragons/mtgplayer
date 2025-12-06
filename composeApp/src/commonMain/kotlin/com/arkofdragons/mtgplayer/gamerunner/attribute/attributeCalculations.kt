package com.arkofdragons.mtgplayer.gamerunner.attribute

import com.arkofdragons.mtgplayer.cardparser.ScryfallCard

fun calculateToughness(originCard: ScryfallCard): ToughnessAttribute? {
    if (originCard.toughness == null) return null

    val parsedInt = originCard.toughness.toIntOrNull()

    if (parsedInt != null) return ToughnessAttribute(parsedInt)

    return ToughnessAttribute(0) // TODO: make variable toughness
}

fun calculatePower(originCard: ScryfallCard): PowerAttribute? {
    if (originCard.power == null) return null

    val parsedInt = originCard.power.toIntOrNull()

    if (parsedInt != null) return PowerAttribute(parsedInt)

    return PowerAttribute(0) // TODO: make variable toughness
}