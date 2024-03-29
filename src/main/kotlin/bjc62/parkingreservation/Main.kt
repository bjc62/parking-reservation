package bjc62.parkingreservation

import bjc62.parkingreservation.plugins.version.one.handleAvailability
import io.ktor.server.application.Application
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.routing.route
import io.ktor.server.routing.routing

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::routeVersion).start(wait = true)
    // reservations:
    // 1. provide avaiability by give time range. return reservation with same owner first, then different owner
    // 2. create new availability with owner id, parking lot number, start time and end time, return reservation id
    // 3. update availability by availability id
    // 4. delete availability, even it is claimed
    // 5. acquire availability and make it become     reservation
    // 6. cancel reservation using its own user id
    // 7. list reservations with users's own user id
}

fun Application.routeVersion() {

    routing {
        route("1.0") {
            route("availability") {
                handleAvailability()
            }
        }
    }
}
