package ru.vood.generator.datamodel.dataType.meta.type

interface DataType<out T> {

    fun value(): T
}