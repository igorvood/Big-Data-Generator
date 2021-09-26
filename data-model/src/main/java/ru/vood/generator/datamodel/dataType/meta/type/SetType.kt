package ru.vood.generator.datamodel.dataType.meta.type

import ru.vood.generator.datamodel.templatedto.DataType

data class SetType<T>(val value: Set<T>) : DataType<Set<T>> {
    override fun value(): Set<T> = value
}