package ru.vood.generator.datamodel.util.function

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ValueAny<T, R>(val id: T, val block: (T)->R) : ReadOnlyProperty<Any, R> {

    override fun getValue(thisRef: Any, property: KProperty<*>): R {
        return block(id)
    }
}

