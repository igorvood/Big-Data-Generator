package ru.vood.generator.datamodel.util.function

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ValueNum<T>(val id: T) : ReadOnlyProperty<Any, Int> {

    override fun getValue(thisRef: Any, property: KProperty<*>): Int {
        return (this.id.toString() + property.name).hashCode()
    }
}

