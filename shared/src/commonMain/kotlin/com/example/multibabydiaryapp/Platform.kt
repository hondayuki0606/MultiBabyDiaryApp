package com.example.multibabydiaryapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform