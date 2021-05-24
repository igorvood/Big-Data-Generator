package ru.vood.generator.big.data.generator.first.dto

data class Score(
        val id: String,
        val crmId: String,
        val inn: String,
        val clus: Set<Clu>
) : MetaGetter<Score> {

    override fun header(): Set<String> {
        return setOf("id",
                "crmId",
                "inn")
    }

    override fun data(): Map<String, Any> {
        return mapOf("id" to id,
                "crmId" to crmId,
                "inn" to inn)
    }
}