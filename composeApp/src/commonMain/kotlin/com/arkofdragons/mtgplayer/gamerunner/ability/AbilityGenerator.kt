package com.arkofdragons.mtgplayer.gamerunner.ability

import com.arkofdragons.mtgplayer.cardparser.ScryfallCard

fun generateAbilities(originCard: ScryfallCard): List<Ability> {
    if (originCard.oracle_text == null) return emptyList();

    val abilityParagraphs = originCard.oracle_text.split("\n")

    val strippedOracleText = stripExtraOracleText(abilityParagraphs)

    println(strippedOracleText)

    val abilities = createAbilities(strippedOracleText)

    /// TODO: Make abilities

    return abilities;
}

fun createAbilities(strippedOracleText: List<String>): List<Ability> {

    val abilities: List<Ability> = strippedOracleText.map { abilityText ->
        val words = abilityText.split(".").map { sentence ->
            sentence.split(Regex("((?<=[.?!,])\\s)")).map { subsentence ->

                subsentence.split(Regex("\\s")).filterNot { word -> word == "" }
            }.filterNot { list -> list.isEmpty() }
        }.filterNot { list -> list.isEmpty() }

        println(words)

        val ability = Ability()


        if (words[0][0][0].equals("when", true) || words[0][0][0].equals("whenever", true)) {
            ability.abilityTypes.add(AbilityType.TRIGGERED)
        }

        if (words[0][0][0].equals("you", true) && words[0][0][1].equals("may", true)) {
            ability.abilityTypes.add(AbilityType.STATIC)
        }

        ability
    }

//    TODO("Not yet implemented")
    return abilities
}

fun stripExtraOracleText(abilityParagraphs: List<String>): List<String> {
    val parenthesisRemoved = abilityParagraphs.map { abilityParagraph ->
        abilityParagraph.split(Regex("\\([^(]*\\)")).joinToString("")
    }

    //todo do something else here because this is dumb
    val preEmdashRequiredPhrases: List<String> = listOf(
        "Choose",
        "Max speed",
        "Ward",
        "Partner",
        "Cumulative",
        "Upkeep",
        "Threshold",
        "Flashback",
        "Suspend",
        "Exhaust"
    )
    val abilityNamesStripped: List<String> = parenthesisRemoved.map { abilityParagraph ->

        val splitParagraph = abilityParagraph.split("—", limit = 2)

        if (splitParagraph.size == 1) {
            splitParagraph[0]
        } else if (splitParagraph[0].contains(
                Regex(
                    preEmdashRequiredPhrases.joinToString("|"),
                    RegexOption.IGNORE_CASE
                )
            )
        ) {
            splitParagraph.joinToString("—")
        } else {
            splitParagraph[1]
        }

    }
    return abilityNamesStripped
}
