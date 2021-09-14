package ru.vood.generator.datamodel.dataType.meta.dsl.n

import ru.vood.generator.datamodel.dataType.meta.MetaEnt

interface Builder<T> {
    fun build(): T
}