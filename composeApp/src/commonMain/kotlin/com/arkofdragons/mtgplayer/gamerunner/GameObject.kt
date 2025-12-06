package com.arkofdragons.mtgplayer.gamerunner

import com.arkofdragons.mtgplayer.cardparser.ScryfallCard
import com.arkofdragons.mtgplayer.gamerunner.ability.Ability
import com.arkofdragons.mtgplayer.gamerunner.ability.generateAbilities
import com.arkofdragons.mtgplayer.gamerunner.attribute.AbilityAttribute
import com.arkofdragons.mtgplayer.gamerunner.attribute.Attribute
import com.arkofdragons.mtgplayer.gamerunner.attribute.calculatePower
import com.arkofdragons.mtgplayer.gamerunner.attribute.calculateToughness
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

            calculateToughness(originCard)?.addTo(gameObject)

            calculatePower(originCard)?.addTo(gameObject)

            //abilities
            val abilities: List<Ability> = generateAbilities(originCard)
            abilities.forEach { ability ->
                gameObject.addAttribute(AbilityAttribute(ability))
            }

            return gameObject
        }
    }
}
