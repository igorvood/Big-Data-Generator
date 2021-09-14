package ru.vood.generator.datamodel.dataType.meta

import ru.vood.generator.datamodel.dataType.meta.type.DataType
import ru.vood.generator.datamodel.dataType.meta.type.EntityTemplate

typealias GenerateIdValueFunction<T> = () -> DataType<T>
typealias GenerateFieldValueFunction<T, OUT_TYPE> = (EntityTemplate<T>, String) -> DataType<OUT_TYPE>
typealias ConstraintName = String
typealias FieldName = String
typealias EntityName = String
//typealias EntityProperty<T> = Map<FieldName, GenerateFieldValueFunction<T>>


//interface GenerateFieldValueFunction<T, OUT_TYPE> : Function2<EntityTemplate<T>, String, DataType<OUT_TYPE>>