package ru.vood.generator.datamodel.util.function

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ValueConst<T>(val value: T) : ReadOnlyProperty<Any, T> {

    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        return value
    }
}

