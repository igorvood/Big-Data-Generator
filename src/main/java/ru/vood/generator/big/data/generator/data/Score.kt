package ru.vood.generator.big.data.generator.data

data class Score(
        val id: String,
        val crmId: String,
        val inn: String,
        val clus: Set<Clu>
)