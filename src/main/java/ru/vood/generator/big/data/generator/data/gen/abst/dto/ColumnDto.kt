package ru.vood.generator.big.data.generator.data.gen.abst.dto

import ru.vood.generator.big.data.generator.data.gen.abst.Types

data class ColumnDto (
        val name: String,
        val type: Types,
        val isAf: Boolean = false,
        val isId: Boolean = false
)