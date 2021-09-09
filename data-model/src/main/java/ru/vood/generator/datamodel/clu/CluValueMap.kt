package ru.vood.generator.datamodel.clu

import ru.vood.generator.datamodel.util.ReadOnlyPropertyMap
import ru.vood.generator.datamodel.valueCalculate
import kotlin.reflect.KProperty

class CluValueMap : ReadOnlyPropertyMap<CluFunctionalDto> {
    override fun getValue(thisRef: CluFunctionalDto, property: KProperty<*>): Map<String, Any> =
        valueCalculate(CluFunctionalDto.fields, property, thisRef)
}
