package ru.vood.generator.flexibledatamodel.meta.type

import ru.vood.generator.flexibledatamodel.dsl.DataType

data class SetType<T>(val value: Set<T>) : DataType<Set<T>> {
    override fun value(): Set<T> = value
}