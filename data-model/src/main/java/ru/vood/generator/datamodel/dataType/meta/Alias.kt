package ru.vood.generator.datamodel.dataType.meta

import ru.vood.generator.datamodel.dataType.meta.type.DataType
import ru.vood.generator.datamodel.score.EntityTemplate

typealias GenerateIdValueFunction<T> = () -> DataType<T>
typealias GenerateFieldValueFunction<T> = (EntityTemplate<T>, String) -> DataType<*>
typealias ConstraintName = String
typealias FieldName = String
typealias EntityName = String
//typealias EntityProperty<T> = Map<FieldName, GenerateFieldValueFunction<T>>