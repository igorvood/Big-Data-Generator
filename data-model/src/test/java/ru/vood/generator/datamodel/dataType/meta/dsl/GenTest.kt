package ru.vood.generator.datamodel.dataType.meta.dsl

import org.junit.jupiter.api.Test
import ru.vood.generator.datamodel.dataType.meta.score.Score.standardScoreMeta
import ru.vood.generator.datamodel.dataType.meta.score.ScoreDto
import ru.vood.generator.datamodel.dataType.meta.score.genFixed
import java.io.File

class GenTest {
    @Test
    fun getName() {

        val meta = standardScoreMeta()
        val gen = genFixed(
            meta,
            { IntRange(1, 2/*0_000_000*/).map { it.toString() }.toSet() },
            { id, m -> ScoreDto(id, m) }
        )
        File("d:/1.log").printWriter().use { out ->
            gen.withIndex().forEach { score ->
                val (i, scoreDto) = score
                val property = scoreDto.meta.property
//                val message = property.first { it.name == "riskSegmentOffline" }
//                val joinToString = property.map { out.print(it(scoreDto)) }.joinToString(";")
                property.forEach { out.println("""${it.name}   ->   ${it(scoreDto)}""") }
                out.println("--------------------------------")
            }
        }
    }
}