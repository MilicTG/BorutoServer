package devs.delminius.plugins

import devs.delminius.routes.getAllHeroes
import devs.delminius.routes.root
import io.ktor.routing.*
import io.ktor.application.*


fun Application.configureRouting() {
    routing {
        root()
        getAllHeroes()
    }
}
