package io.github.kirade.simplemember

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleMemberApplication

fun main(args: Array<String>) {
    runApplication<SimpleMemberApplication>(*args)
}
