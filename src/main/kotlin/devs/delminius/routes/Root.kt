package devs.delminius.routes

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.root() {
    get(path = "/") {
        call.respond(
            message = "Welcome to Boruto API!",
            status = HttpStatusCode.OK
        )
    }
}