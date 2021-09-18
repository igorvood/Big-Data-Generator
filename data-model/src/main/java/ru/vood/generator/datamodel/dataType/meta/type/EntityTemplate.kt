package ru.vood.generator.datamodel.dataType.meta.type

abstract class EntityTemplate<ID_TYPE : DataType<*>>(val id: ID_TYPE) : DataType<EntityTemplate<ID_TYPE>> {
//    val id: T

//    var property: MutableMap<String, (EntityTemplate<T>, String) -> DataType<Any>> = mutableMapOf()

    override fun value(): EntityTemplate<ID_TYPE> = this
}