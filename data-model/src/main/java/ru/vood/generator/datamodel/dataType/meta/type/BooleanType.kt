package ru.vood.generator.datamodel.dataType.meta.type

import ru.vood.generator.datamodel.templatedto.DataType

data class BooleanType(val value: Boolean) : DataType<Boolean> {
    override fun value(): Boolean = value
}