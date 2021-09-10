package ru.vood.generator.big.data.generator.first.dto

data class Clu(
    val id: String,
    val name: String
) : MetaGetter<Clu> {
    override fun header(): Set<String> {
        return setOf(
            "id",
            "name"
        )
    }

    override fun data(): Map<String, Any> {
        return mapOf(
            "id" to id,
            "name" to name
        )
    }
}