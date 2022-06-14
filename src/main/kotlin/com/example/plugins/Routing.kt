package com.example.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

import java.net.InetAddress
import java.net.UnknownHostException

fun Application.configureRouting() {

    routing {
        get("/") {
            val addr = InetAddress.getLocalHost();
            val hostname = addr.getHostName();
            
            call.respondText("Hi from $hostname")
        }

        get("/{path...}") {
            call.respondText(
                join(call.parameters.getAll("path") ?: listOf("Hi"))
            )
        }
    }
}

fun join(listOfParams: List<String>) = listOfParams.joinToString(", ")
