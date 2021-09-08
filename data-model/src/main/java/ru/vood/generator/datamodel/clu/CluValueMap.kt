package ru.vood.generator.datamodel.clu

import ru.vood.generator.datamodel.score.ScoreFunctionalDto
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty
import kotlin.reflect.KVisibility

class CluValueMap : ReadOnlyProperty<CluFunctionalDto, Map<String, Any?>> {
    override fun getValue(thisRef: CluFunctionalDto, property: KProperty<*>): Map<String, Any?> {
        val fields = CluFunctionalDto.fields

        val map: Map<String, Any?> = fields
            .asSequence()
            .filter { it.visibility != KVisibility.PRIVATE }
            .filter { it.name != property.name }
            .filter {
                !(it.name in listOf(
                    "component1",
                    "copy",
                    "equals",
                    "hashCode",
                    "toString"
                ))
            }
            .map {
                try {
                    it.name to it.call(thisRef)
                } catch (e: Exception) {
                    println(it.name)
                    throw e
                }

            }.filter { it.second != null }
            .toList()
            .toMap()
        return map
    }
}
