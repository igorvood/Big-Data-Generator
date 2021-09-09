package ru.vood.generator.datamodel.score

import ru.vood.generator.datamodel.valueCalculate
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KCallable
import kotlin.reflect.KProperty
import kotlin.reflect.KVisibility

class ScoreValueMap : ReadOnlyProperty<ScoreFunctionalDto, Map<String, Any?>> {

    override fun getValue(thisRef: ScoreFunctionalDto, property: KProperty<*>): Map<String, Any?> {
        val fields: Set<KCallable<*>> = ScoreFunctionalDto.fields

        val map: Map<String, Any?> = valueCalculate(fields, property, thisRef)
        return map
    }

}