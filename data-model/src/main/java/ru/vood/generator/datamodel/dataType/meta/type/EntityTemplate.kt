package ru.vood.generator.datamodel.dataType.meta.type

abstract class EntityTemplate<T>(val id: T) : DataType<EntityTemplate<T>> {
//    val id: T

    var property: MutableMap<String, (EntityTemplate<T>, String) -> DataType<Any>> = mutableMapOf()

    override fun value(): EntityTemplate<T> = this
}