package ru.vood.generator.datamodel.dataType.meta.dsl

import ru.vood.generator.datamodel.dataType.meta.type.DataType
import ru.vood.generator.datamodel.dataType.meta.type.EntityTemplate

data class MetaEntity<T : EntityTemplate<ID_TYPE>, ID_TYPE : DataType<*>>
//        where T: EntityTemplate<Q>
    (
    val name: EntityName,
    val property: Set<MetaProperty<ID_TYPE, *>>,
    val ck: Set<MetaCheck<T>> = setOf(),
    val fk: Set<MetaFk<T>> = setOf(),
)

data class MetaProperty<ID_TYPE : DataType<*>, OUT_TYPE>(
    val name: FieldName,
    val function: GenerateFieldValueFunction<ID_TYPE, OUT_TYPE>
)

data class MetaCheck<T>(
    val name: ConstraintName,
    val checkFunction: ()->Boolean
)

data class MetaFk<T>(
    val name: ConstraintName
)
