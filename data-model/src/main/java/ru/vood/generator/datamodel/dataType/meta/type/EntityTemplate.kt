package ru.vood.generator.datamodel.dataType.meta.type

import ru.vood.generator.datamodel.dataType.meta.dsl.MetaEntity

abstract class EntityTemplate<ID_TYPE : DataType<*>>(
    val id: ID_TYPE,
    val meta: MetaEntity<EntityTemplate<ID_TYPE>, ID_TYPE>
) : DataType<EntityTemplate<ID_TYPE>> {

    override fun value(): EntityTemplate<ID_TYPE> = this

}