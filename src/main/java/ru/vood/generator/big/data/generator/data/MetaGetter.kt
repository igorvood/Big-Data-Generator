package ru.vood.generator.big.data.generator.data

interface MetaGetter<T> {

    fun header(): Set< String>
    fun data(): Map<String, Any>

}
