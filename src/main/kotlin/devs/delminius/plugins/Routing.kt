package devs.delminius.plugins

import devs.delminius.routes.getAllHeroes
import devs.delminius.routes.root
import devs.delminius.routes.searchHeroes
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.http.content.*


fun Application.configureRouting() {
    routing {
        root()
        getAllHeroes()
        searchHeroes()

        static(remotePath = "/images") {
            resources(resourcePackage = "images")
        }
    }
}
