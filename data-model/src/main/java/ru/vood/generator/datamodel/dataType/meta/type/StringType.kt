package ru.vood.generator.datamodel.dataType.meta.type

data class StringType(val value: () -> String?) : DataType<String?> {
    override fun value(): String? = value()
}