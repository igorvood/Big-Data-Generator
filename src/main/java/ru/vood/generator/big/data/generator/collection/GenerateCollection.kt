package ru.vood.generator.big.data.generator.collection

import ru.vood.generator.big.data.generator.simpleGen.GeneratorData

interface GenerateCollection {

    fun <T> genList(min: Int = 0, max: Int, gen: GeneratorData<T>): List<T>

    fun <T> genSet(min: Int = 0, max: Int, gen: GeneratorData<T>): Set<T> = genList(min, max, gen).toSet()
}