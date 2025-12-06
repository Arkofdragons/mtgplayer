package com.arkofdragons.mtgplayer.gamerunner

import com.arkofdragons.mtgplayer.cardparser.ScryfallCard
import com.arkofdragons.mtgplayer.gamerunner.attribute.*
import kotlinx.serialization.Serializable

@Serializable
class GameObject {
    fun addAttribute(attribute: Attribute<*>) {
        attributes += attribute
    }

    var attributes: List<Attribute<*>> = mutableListOf()

    companion object {
        fun initializeFromScryfallCard(originCard: ScryfallCard): GameObject {
            val gameObject = GameObject()

            calculateToughness(originCard)?.let { toughness: ToughnessAttribute ->
                gameObject.addAttribute(toughness)
            }

            calculatePower(originCard)?.let { power: PowerAttribute ->
                gameObject.addAttribute(power)
            }

            //abilities

            return gameObject
        }
    }
}
