package ru.vood.generator.flexibledatamodel

interface DataType<out T> {

    fun value(): T
}