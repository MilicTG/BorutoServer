package devs.delminius

import io.ktor.http.*
import io.ktor.application.*
import kotlin.test.*
import io.ktor.server.testing.*

class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(
                    HttpStatusCode.OK,
                    response.status()
                )
                assertEquals(
                    expected = "Welocome to Boeuto API!",
                    response.content
                )
            }
        }
    }
}