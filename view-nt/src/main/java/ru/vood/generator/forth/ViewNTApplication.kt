package ru.vood.generator.forth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties
open class ViewNTApplication

fun main(args: Array<String>) {
    runApplication<ViewNTApplication>(*args)
}