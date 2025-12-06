package com.arkofdragons.mtgplayer.cardparser

import com.arkofdragons.mtgplayer.gamerunner.GameObject
import kotlinx.io.buffered
import kotlinx.io.files.Path
import kotlinx.io.files.SystemFileSystem
import kotlinx.io.readString
import kotlinx.serialization.json.Json

fun ParseCards() {

    println(SystemFileSystem.resolve(Path(".")))

    val rawJson: String = SystemFileSystem.source(Path("./testdata/oracle-test-data-20251206.json"))
        .use { source -> source.buffered().readString() }

    val scryfallCards: List<ScryfallCard> = Json.decodeFromString<List<ScryfallCard>>(rawJson)

    val card1: GameObject = GameObject.initializeFromScryfallCard(scryfallCards[0])

    println(Json.encodeToString(card1))

    println(Json.encodeToString(GameObject.initializeFromScryfallCard(scryfallCards[6])))
}