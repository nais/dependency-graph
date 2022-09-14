package io.nais

import io.ktor.http.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlin.test.*
import io.ktor.server.testing.*
import io.nais.plugins.*

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        application {
            configureRouting()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello World!", bodyAsText())
        }
    }

    @Test
    fun testData() = testApplication {
        application {
            configureRouting()
        }
        client.get("/data").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("""{"names": ["Truls", "Audun"]}""", bodyAsText())
        }
    }
}