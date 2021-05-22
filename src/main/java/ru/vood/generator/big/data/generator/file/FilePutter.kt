package ru.vood.generator.big.data.generator.file

import ru.vood.generator.big.data.generator.data.MetaGetter

interface FilePutter {

    fun <T : MetaGetter<T>> toFile(t: List<T>)
}