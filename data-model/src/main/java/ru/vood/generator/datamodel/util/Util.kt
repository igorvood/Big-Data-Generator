package ru.vood.generator.datamodel

import ru.vood.generator.datamodel.clu.CluFunctionalDto
import kotlin.reflect.KCallable
import kotlin.reflect.KProperty
import kotlin.reflect.KVisibility

fun <T> valueCalculate(
    fields: Set<KCallable<*>>,
    property: KProperty<*>,
    thisRef: T
): Map<String, Any> {
    return fields
        .asSequence()
        .filter { it.visibility != KVisibility.PRIVATE }
        .filter { it.name != property.name }
        .filter {
            it.name !in listOf(
                "component1",
                "copy",
                "equals",
                "hashCode",
                "toString"
            )
        }
        .map {
            try {
                it.name to it.call(thisRef)
            } catch (e: Exception) {
                println(it.name)
                throw e
            }
        }
        .filter { it.second != null }
        .map { it.first to it.second!! }
        .toList()
        .toMap()
}

inline fun <reified T> dataFields(): Set<KCallable<*>> {
    return T::class.members
        .filterIsInstance<KProperty<*>>()
        .toSet()
}