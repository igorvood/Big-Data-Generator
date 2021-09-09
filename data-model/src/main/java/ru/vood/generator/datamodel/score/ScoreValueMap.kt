package ru.vood.generator.datamodel.score

import ru.vood.generator.datamodel.util.ReadOnlyPropertyMap
import ru.vood.generator.datamodel.valueCalculate
import kotlin.reflect.KProperty

class ScoreValueMap : ReadOnlyPropertyMap<ScoreFunctionalDto> {

    override fun getValue(thisRef: ScoreFunctionalDto, property: KProperty<*>) =
        valueCalculate(ScoreFunctionalDto.fields, property, thisRef)

}