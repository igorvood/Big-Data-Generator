package ru.vood.generator.flexibledatamodel.dsl

interface Builder<T> {
    fun build(): T
}