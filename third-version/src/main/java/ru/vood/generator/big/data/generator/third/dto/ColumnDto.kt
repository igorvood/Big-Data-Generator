package ru.vood.generator.big.data.generator.third.dto


data class ColumnDto(
    val name: String,
    val type: Types,
    val isAf: Boolean = false,
    val isId: Boolean = false
)