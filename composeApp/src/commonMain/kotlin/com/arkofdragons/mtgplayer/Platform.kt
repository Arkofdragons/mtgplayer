package com.arkofdragons.mtgplayer

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform