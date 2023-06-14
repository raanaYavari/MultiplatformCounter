package com.raana.multipatformapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform