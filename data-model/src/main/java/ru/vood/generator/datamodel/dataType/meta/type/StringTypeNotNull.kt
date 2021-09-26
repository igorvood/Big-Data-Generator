package ru.vood.generator.datamodel.dataType.meta.type

import ru.vood.generator.datamodel.templatedto.DataType

data class StringTypeNotNull(val value: String) : DataType<String> {
    override fun value(): String = value
}