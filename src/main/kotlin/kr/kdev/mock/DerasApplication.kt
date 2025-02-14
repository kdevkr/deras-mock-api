package kr.kdev.mock

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DerasApplication

fun main(args: Array<String>) {
    runApplication<DerasApplication>(*args)
}
