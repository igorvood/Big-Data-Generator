package ru.vood.generator.datamodel.score

import ru.vood.generator.datamodel.dataType.meta.type.DataType

abstract class EntityTemplate<T>(val id: T) : DataType<EntityTemplate<T>> {
//    val id: T

    var property: MutableMap<String, (EntityTemplate<T>, String) -> DataType<*>> = mutableMapOf()

    override fun value(): EntityTemplate<T> = this
}