package ru.vood.generator.forth.rest

import org.springframework.web.bind.annotation.PathVariable

interface EntityRestControllerService<T> {

    fun readEntity(@PathVariable entityId: String): T

    fun readEntityByMap(@PathVariable entityId: String): Map<String, Any?>
}