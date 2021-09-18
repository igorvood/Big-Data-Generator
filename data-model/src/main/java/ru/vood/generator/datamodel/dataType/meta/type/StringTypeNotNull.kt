package ru.vood.generator.datamodel.dataType.meta.type

data class StringTypeNotNull(val value: String) : DataType<String> {
    override fun value(): String = value
}