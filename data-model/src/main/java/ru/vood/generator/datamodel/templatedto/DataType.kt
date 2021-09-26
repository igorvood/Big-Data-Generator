package ru.vood.generator.datamodel.templatedto

interface DataType<out T> {

    fun value(): T
}