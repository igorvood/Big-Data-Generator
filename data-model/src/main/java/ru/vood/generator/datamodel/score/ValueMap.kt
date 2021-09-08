package ru.vood.generator.datamodel.score

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty
import kotlin.reflect.KVisibility

class ValueMap : ReadOnlyProperty<ScoreFunctionalDto, Map<String, Any?>> {

    override fun getValue(thisRef: ScoreFunctionalDto, property: KProperty<*>): Map<String, Any?> {
        val fields = ScoreFunctionalDto.fields

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