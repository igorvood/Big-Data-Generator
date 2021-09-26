package ru.vood.generator.datamodel.templatedto.dsl

import ru.vood.generator.datamodel.templatedto.DataType
import ru.vood.generator.datamodel.templatedto.EntityTemplate

typealias GenerateIdValueFunction<T> = () -> DataType<T>
typealias GenerateFieldValueFunction<ID_TYPE, OUT_TYPE> = (EntityTemplate<ID_TYPE>, String) -> OUT_TYPE
typealias GenerateFieldValueFunctionDsl<ID_TYPE, OUT_TYPE> = (EntityTemplate<ID_TYPE>, String) -> OUT_TYPE
typealias GenerateFieldCheckFunction<ID_TYPE> = (EntityTemplate<ID_TYPE>, String) -> Boolean

typealias ConstraintName = String
typealias FieldName = String
typealias EntityName = String


