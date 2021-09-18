package ru.vood.generator.datamodel.dataType.meta.dsl

interface Builder<T> {
    fun build(): T
}