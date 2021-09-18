package ru.vood.generator.datamodel.dataType.meta.dsl

import ru.vood.generator.datamodel.dataType.meta.type.DataType
import ru.vood.generator.datamodel.dataType.meta.type.EntityTemplate

typealias GenerateIdValueFunction<T> = () -> DataType<T>
typealias GenerateFieldValueFunction<ID_TYPE, OUT_TYPE> = (EntityTemplate<ID_TYPE>, String) -> DataType<OUT_TYPE>
typealias GenerateFieldValueFunctionDsl<ID_TYPE, OUT_TYPE> = (EntityTemplate<ID_TYPE>, String) -> OUT_TYPE

typealias ConstraintName = String
typealias FieldName = String
typealias EntityName = String


