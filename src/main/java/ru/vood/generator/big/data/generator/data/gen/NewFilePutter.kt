package ru.vood.generator.big.data.generator.data.gen

interface NewFilePutter {

    fun <T : MetaDataInterface> toFile(t: List<T>, a: MapGenerator<T>)
}