package kr.kdev.mock

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.core.WireMockConfiguration.options
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
)
class DerasApiTest :
    FunSpec({
        val port = 8080
        val wireMockServer = WireMockServer(options().port(port))

        beforeTest {
            // setup
            wireMockServer.start()
            WireMock.configureFor(port)
        }

        test("Port is configured") {
            port shouldBe 8080
        }

        afterTest {
            // teardown
            wireMockServer.resetAll()
            wireMockServer.stop()
        }
    })
