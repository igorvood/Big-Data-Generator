package ru.vood.generator.datamodel.util.function

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ValueString<T>(val id: T) : ReadOnlyProperty<Any, String> {

    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        return this.id.toString() + property.name
    }
}

