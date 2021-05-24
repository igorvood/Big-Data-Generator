package ru.vood.generator.big.data.generator.third.dto

data class EntityDto(
        val name: String,
        val columns: Set<ColumnDto>
)