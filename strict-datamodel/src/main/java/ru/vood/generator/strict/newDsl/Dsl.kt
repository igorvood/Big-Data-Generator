package ru.vood.generator.strict.newDsl

import ru.vood.generator.strict.DataType
import ru.vood.generator.strict.dsl.GenerateFieldValueFunction
import ru.vood.generator.strict.dsl.GenerateFieldValueFunctionDsl
import ru.vood.generator.strict.dsl.MetaProperty

/*
inline fun <reified ET> string() = PropBuilder<ET, String>()

inline infix fun <reified ET_ID_TYPE, reified R> PropBuilder<ET_ID_TYPE, R>.genVal(
    crossinline f: GenerateFieldValueFunctionDsl<ET_ID_TYPE, R>
): PropBuilder<ET_ID_TYPE, R> {
    this.function =
        { entityTemplate, parameterName ->
            object : DataType<R> {
                override fun invoke(): R  = f(entityTemplate, parameterName)
            }
        }
    return this
}

inline fun <reified ET_ID_TYPE, reified R> MetaProperty<ET_ID_TYPE, R>.getFun(): GenerateFieldValueFunction<ET_ID_TYPE, DataType<R>> {
    return this.function
}*/
