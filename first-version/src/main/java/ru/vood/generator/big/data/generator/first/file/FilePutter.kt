package ru.vood.generator.big.data.generator.first.file

import ru.vood.generator.big.data.generator.first.dto.MetaGetter

interface FilePutter {

    fun <T : MetaGetter<T>> toFile(t: List<T>)
}