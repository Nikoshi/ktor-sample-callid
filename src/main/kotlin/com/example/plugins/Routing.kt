package com.example.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText(call.callId)
        }

        get("/{path...}") {
            call.respondText(
                join(call.parameters.getAll("path") ?: listOf("Hi"))
            )
        }
    }
}

fun join(listOfParams: List<String>) = listOfParams.joinToString(", ")
