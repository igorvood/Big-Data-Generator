package ru.vood.generator.flexibledatamodel.dsl

interface DataType<out T> {

    fun value(): T
}