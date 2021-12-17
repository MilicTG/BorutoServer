package devs.delminius

import devs.delminius.models.ApiResponse
import devs.delminius.repository.HeroRepository
import io.ktor.http.*
import io.ktor.application.*
import kotlin.test.*
import io.ktor.server.testing.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.koin.java.KoinJavaComponent.inject

class ApplicationTest {

    private val heroRepository: HeroRepository by inject(HeroRepository::class.java)

    @Test
    fun `access root endpoint, assert correct information`() {
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

    @Test
    fun `access all heroes endpoint, assert correct information`() {
        withTestApplication(moduleFunction = Application::module) {
            handleRequest(HttpMethod.Get, "/boruto/heroes").apply {
                assertEquals(
                    expected = HttpStatusCode.OK,
                    actual = response.status()
                )
                val expected = ApiResponse(
                    success = true,
                    message = "ok",
                    prevPage = null,
                    nextPage = 2,
                    heroes = heroRepository.page1,
                    lastUpdated = System.currentTimeMillis()
                )
                val actual = Json.decodeFromString<ApiResponse>(response.content.toString())
                println("EXPECTED $expected")
                println("ACTUAL $actual")
                assertEquals(
                    expected = expected,
                    actual = actual
                )
            }
        }
    }
}