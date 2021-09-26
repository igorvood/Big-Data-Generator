package ru.vood.generator.datamodel.templatedto.dsl

interface Builder<T> {
    fun build(): T
}