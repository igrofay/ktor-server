package com.piper

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.piper.plugins.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.serialization.*
import java.net.InetAddress

fun main() {

    embeddedServer(Netty ,  port = System.getenv("PORT").toInt()) {
        module()
    }.start(wait = true)
}

fun Application.module() {
    settings()
    chat()
}

fun Application.settings(){
    install(ContentNegotiation) {
        json()
    }

}