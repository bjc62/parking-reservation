package bjc62.parkingreservation.plugins.version.one

import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.post

fun Route.handleAvailability() {
    get() {
        call.respondText { "1.0 handleAvailability get" }
    }

    post() {
        call.respondText { "1.0 handleAvailability post" }
    }
}
