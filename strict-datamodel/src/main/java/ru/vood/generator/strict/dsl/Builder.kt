package ru.vood.generator.strict.dsl

interface Builder<T> {
    fun build(): T
}