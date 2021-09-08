package ru.vood.generator.datamodel.score

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ValueMap : ReadOnlyProperty<ScoreFunctionalDto, Map<String, Any?>> {

    override fun getValue(thisRef: ScoreFunctionalDto, property: KProperty<*>): Map<String, Any?> {
        val fields = ScoreFunctionalDto.fields
        val map: Map<String, Any?> = fields
//            .filter { it.name=="crmId" }
            .map {
                it.name to it.call(thisRef)
            }.filter { it.second!=null }
            .toMap()
        return map
    }
}