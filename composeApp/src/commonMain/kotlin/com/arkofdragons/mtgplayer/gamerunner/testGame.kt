package com.arkofdragons.mtgplayer.gamerunner

import com.arkofdragons.mtgplayer.gamerunner.attribute.PowerAttribute
import com.arkofdragons.mtgplayer.gamerunner.attribute.ToughnessAttribute

fun testGame() {

    val subject1 = GameObject()
    subject1.addAttribute(ToughnessAttribute(1))
    subject1.addAttribute(PowerAttribute(2))

    val subject2 = GameObject()
    subject2.addAttribute(ToughnessAttribute(3))
    subject2.addAttribute(PowerAttribute(1))
}