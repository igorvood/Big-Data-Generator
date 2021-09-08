package ru.vood.generator.forth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class ForthApplication

fun main(args: Array<String>) {
    runApplication<ForthApplication>(*args)
}