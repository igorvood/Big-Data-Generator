package ru.vood.generator.datamodel.dataType.meta.type

import ru.vood.generator.datamodel.dataType.meta.dsl.MetaEntity

abstract class EntityTemplate<ID_TYPE>(
    id: ID_TYPE,
    val meta: MetaEntity<ID_TYPE>
) : DataType<EntityTemplate<ID_TYPE>> {

    val id: DataType<ID_TYPE> = object : DataType<ID_TYPE> {
        override fun value(): ID_TYPE {
            return id
        }
    }

    override fun value(): EntityTemplate<ID_TYPE> = this
}