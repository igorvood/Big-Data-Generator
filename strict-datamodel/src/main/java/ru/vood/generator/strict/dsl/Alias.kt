package ru.vood.generator.strict.dsl

import ru.vood.generator.strict.DataType
import ru.vood.generator.strict.EntityTemplate

typealias GenerateIdValueFunction<T> = () -> DataType<T>
typealias GenerateFieldValueFunction<ID_TYPE, OUT_TYPE> = (EntityTemplate<ID_TYPE>, String) -> OUT_TYPE
typealias GenerateFieldValueFunctionDsl<ID_TYPE, OUT_TYPE> = (EntityTemplate<ID_TYPE>, String) -> OUT_TYPE
typealias GenerateFieldCheckFunction<ID_TYPE> = (EntityTemplate<ID_TYPE>, String) -> Boolean

typealias ConstraintName = String
typealias FieldName = String
typealias EntityName = String


