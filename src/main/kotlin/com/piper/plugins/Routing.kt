package com.piper.plugins

import com.piper.Customer
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*

val customerStorage = mutableListOf<Customer>(Customer("0", "Igot" , "Fridov", "iddnc@gmail.com"))

fun Application.configureRouting() {
    // Starting point for a Ktor app:
    routing {

        get("/") {
            call.respondText("Hello World!")
            println(1)
        }
        customerRouting()
    }
}

fun Route.customerRouting() {
    route("/customer") {
        get {
            if (customerStorage.isNotEmpty()) {
                call.respond(customerStorage)
            } else {
                call.respondText("No customers found", status = HttpStatusCode.NotFound)
            }
        }
        get("{id}") {

        }
        post {

        }
        delete("{id}") {

        }
    }
}