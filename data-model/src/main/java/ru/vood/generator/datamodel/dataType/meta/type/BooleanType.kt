package ru.vood.generator.datamodel.dataType.meta.type

data class BooleanType(val value: Boolean) : DataType<Boolean> {
    override fun value(): Boolean = value
}