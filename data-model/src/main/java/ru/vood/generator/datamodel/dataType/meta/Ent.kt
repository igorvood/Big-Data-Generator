package ru.vood.generator.datamodel.dataType.meta

data class Ent<T>(
    val name: EntityName,
    val property: Set<EntProperty<T>>,
    val ck: Set<EntCk<T>>,
    val fk: Set<EntFk<T>>,
)

data class EntProperty<T>(
    val name: FieldName,
    val function: GenerateFieldValueFunction<T>
)

data class EntCk<T>(
    val name: ConstraintName
)

data class EntFk<T>(
    val name: ConstraintName
)
