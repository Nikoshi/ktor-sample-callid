package com.example

import com.example.plugins.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 5555, host = "0.0.0.0") {
        configureHTTP()
        configureRouting()
        configureMonitoring()
    }.start(wait = true)
}
