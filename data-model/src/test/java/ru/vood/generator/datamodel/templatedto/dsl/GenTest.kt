package ru.vood.generator.datamodel.templatedto.dsl

import io.mockk.InternalPlatformDsl.toStr
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.vood.generator.datamodel.templatedto.dsl.StandardFunction.genEntityData
import ru.vood.generator.datamodel.templatedto.meta.score.Score.standardScoreMeta
import ru.vood.generator.datamodel.templatedto.meta.score.ScoreDto
import java.io.File

class GenTest {
    lateinit var meta: MetaEntity<String>
    lateinit var gen: Set<ScoreDto>

            val endInclusive = 16_000
//    val endInclusive = 20_000_000
//    val endInclusive = 2000
//    val endInclusive = 2

    @BeforeEach
    private fun setup() {
        meta = standardScoreMeta()

        gen = genEntityData(
            meta,
            { IntRange(1, endInclusive).map { it.toString() }.toSet() },
            { id, m -> ScoreDto(id, m) }
        )
    }

    @Test
    fun getEntityToFile() {

        gen.withIndex().forEach { score ->
            val (i, scoreDto) = score
            val property = scoreDto.meta.property
            property.forEach { println("""${it.name}   ->   ${it(scoreDto)}""") }
            println("--------------------------------")
        }
        /*  File("d:/1.log").printWriter().use { out ->
              gen.withIndex().forEach { score ->
                  val (i, scoreDto) = score
                  scoreDto.getJson()
                  out.println(scoreDto.getJson())
                  if (i % 500 == 0) {
                      println("сгененрировано $i ")
                  }
  //                val property = scoreDto.meta.property
  //                property.forEach { out.println("""${it.name}   ->   ${it(scoreDto)}""") }
  //                out.println("--------------------------------")
              }
          }*/
    }

    @Test
    fun getEntityToSeparateFile() {
        gen.withIndex().forEach { score ->
            val (i, scoreDto) = score
            scoreDto.getJson()
            if (i % 500 == 0) {
                println("сгененрировано $i ")
            }
            File("d:temp/gen/${scoreDto.id.value()}.log").printWriter().use { out ->
                out.println(scoreDto.getJson())
            }
        }
    }


    @Test
    fun toJson() {
        val score = gen.first()
        val json = score.getJson()
        json.asJsonObject.toStr()
        println(json)
    }

}