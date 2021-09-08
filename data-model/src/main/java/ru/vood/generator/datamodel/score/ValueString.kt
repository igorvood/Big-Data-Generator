package ru.vood.generator.datamodel.score

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ValueString(val id: String) : ReadOnlyProperty<ScoreFunctionalDto, String> {

    override fun getValue(thisRef: ScoreFunctionalDto, property: KProperty<*>): String {
      return  this.id + property.name

    }
}

