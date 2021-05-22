package ru.vood.generator.big.data.generator.data.gen.score

import ru.vood.generator.big.data.generator.data.gen.MetaDataInterface

class Score(
        val id: String,
        val crmId: (String) -> String = { it },
        val inn: (String) -> String = { it }
) : MetaDataInterface {
    companion object {
        val SCORE_HEADERS = ScoreMeta.values().map { it.s }.toSet()
    }

    override fun headers() = SCORE_HEADERS
}

