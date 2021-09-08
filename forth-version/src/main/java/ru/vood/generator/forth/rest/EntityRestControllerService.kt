package ru.vood.generator.forth.rest

import org.springframework.web.bind.annotation.PathVariable

interface EntityRestControllerService<T> {

    fun readEntity(@PathVariable entityId: String): T
}