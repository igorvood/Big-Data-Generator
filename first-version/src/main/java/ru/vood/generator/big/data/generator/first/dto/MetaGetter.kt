package ru.vood.generator.big.data.generator.first.dto

interface MetaGetter<T> {

    fun header(): Set< String>
    fun data(): Map<String, Any>

}
