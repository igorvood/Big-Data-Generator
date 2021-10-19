package ru.vood.generator.flexibledatamodel.meta.type

import ru.vood.generator.flexibledatamodel.dsl.DataType


data class BooleanType(val value: Boolean) : DataType<Boolean> {
    override fun value(): Boolean = value
}