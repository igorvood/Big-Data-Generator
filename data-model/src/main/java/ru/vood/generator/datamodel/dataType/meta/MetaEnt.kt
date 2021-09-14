package ru.vood.generator.datamodel.dataType.meta

data class MetaEnt<T>(
    val name: EntityName,
    val property: Set<MetaProperty<T, *>>,
    val ck: Set<MetaCk<T>> = setOf(),
    val fk: Set<MetaFk<T>> = setOf(),
)

data class MetaProperty<P, OUT_TYPE>(
    val name: FieldName,
    val function: GenerateFieldValueFunction<P, OUT_TYPE>
)

data class MetaCk<T>(
    val name: ConstraintName
)

data class MetaFk<T>(
    val name: ConstraintName
)
