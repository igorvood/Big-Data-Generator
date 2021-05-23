package ru.vood.generator.big.data.generator.data.gen.abst.dto

data class EntityDto(
        val name: String,
        val columns: Set<ColumnDto>
)