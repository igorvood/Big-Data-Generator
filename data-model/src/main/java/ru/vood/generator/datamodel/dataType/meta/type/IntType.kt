package ru.vood.generator.datamodel.dataType.meta.type

data class IntType(val value: ()->Int) : DataType<Int> {
    override fun value(): Int = value()
}