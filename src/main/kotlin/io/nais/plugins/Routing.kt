package io.nais.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/data") {
            println("called")
            call.respondText("""    
                {"names": ["Truls", "Audun"]}
            """.trimIndent(), ContentType.Application.Json)
        }
        // Static plugin. Try to access `/viz/index.html`
        static("/viz") {
            resources("webapp")
        }
    }
}
