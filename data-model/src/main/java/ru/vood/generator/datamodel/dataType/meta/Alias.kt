package ru.vood.generator.datamodel.dataType.meta

import ru.vood.generator.datamodel.dataType.meta.type.DataType
import ru.vood.generator.datamodel.dataType.meta.type.EntityTemplate

typealias GenerateIdValueFunction<T> = () -> DataType<T>
typealias GenerateFieldValueFunction<T, OUT_TYPE> = (EntityTemplate<T>, String) -> DataType<OUT_TYPE>
typealias GenerateFieldValueFunctionDsl<T, OUT_TYPE> = (EntityTemplate<T>, String) -> () -> OUT_TYPE


typealias ConstraintName = String
typealias FieldName = String
typealias EntityName = String


fun <T, OUT_TYPE> convert(f: GenerateFieldValueFunctionDsl<T, OUT_TYPE>): GenerateFieldValueFunction<T, OUT_TYPE> {
    return object : GenerateFieldValueFunction<T, OUT_TYPE> {
        override fun invoke(p1: EntityTemplate<T>, p2: String): DataType<OUT_TYPE> {
            return object : DataType<OUT_TYPE> {
                override fun value(): OUT_TYPE {
                    return f(p1, p2)()
                }
            }
        }
    }
}
//typealias EntityProperty<T> = Map<FieldName, GenerateFieldValueFunction<T>>


//interface GenerateFieldValueFunction<T, OUT_TYPE> : Function2<EntityTemplate<T>, String, DataType<OUT_TYPE>>