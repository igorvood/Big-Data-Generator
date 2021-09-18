package ru.vood.generator.datamodel.dataType.meta.dsl

import ru.vood.generator.datamodel.dataType.meta.type.DataType
import ru.vood.generator.datamodel.dataType.meta.type.EntityTemplate

typealias GenerateIdValueFunction<T> = () -> DataType<T>
typealias GenerateFieldValueFunction<T, OUT_TYPE> = (EntityTemplate<T>, String) -> DataType<OUT_TYPE>
typealias GenerateFieldValueFunctionDsl<T, OUT_TYPE> = (EntityTemplate<T>, String) -> OUT_TYPE

typealias ConstraintName = String
typealias FieldName = String
typealias EntityName = String


