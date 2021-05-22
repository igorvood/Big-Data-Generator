package ru.vood.generator.big.data.generator.data.gen.score

import ru.vood.generator.big.data.generator.data.gen.DataInterface

class Score(
        val id: String
) : DataInterface {
    companion object {
        val SCORE_HEADERS = ScoreMeta.values().map { it.s }.toSet()
    }

    inline fun crmId(f: (String) -> String = { it }): String {
        return f.invoke(this.id)
    }

    inline fun inn(f: (String) -> String = { it }): String {
        return f.invoke(this.id)
    }

    override fun headers() = SCORE_HEADERS

}

