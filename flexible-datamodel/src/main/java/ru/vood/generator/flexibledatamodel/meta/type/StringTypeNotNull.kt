package ru.vood.generator.flexibledatamodel.meta.type

import ru.vood.generator.flexibledatamodel.dsl.DataType

data class StringTypeNotNull(val value: String) : DataType<String> {
    override fun value(): String = value
}