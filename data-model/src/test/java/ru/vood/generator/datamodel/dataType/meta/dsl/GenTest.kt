package ru.vood.generator.datamodel.dataType.meta.dsl

import org.junit.jupiter.api.Test
import ru.vood.generator.datamodel.dataType.meta.score.Score.standardScoreMeta
import ru.vood.generator.datamodel.dataType.meta.score.ScoreDto
import ru.vood.generator.datamodel.dataType.meta.score.genFixed

class GenTest {
    @Test
    fun getName() {

        val meta = standardScoreMeta()
        val gen = genFixed(
            meta,
            { IntRange(1, 2).map { it.toString() }.toSet() },
            { id, m -> ScoreDto(id, m) }
        )
        gen.forEach { score ->
            val property = score.meta.property
            val message = property.first { it.name == "riskSegmentOffline" }
            println(message(score))
        }
    }
}