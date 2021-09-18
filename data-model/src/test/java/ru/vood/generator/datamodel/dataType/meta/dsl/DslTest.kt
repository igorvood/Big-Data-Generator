package ru.vood.generator.datamodel.dataType.meta.dsl

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.vood.generator.datamodel.dataType.meta.GenerateFieldValueFunction
import ru.vood.generator.datamodel.dataType.meta.MetaEnt
import ru.vood.generator.datamodel.dataType.meta.MetaProperty
import ru.vood.generator.datamodel.dataType.meta.score.ScoreDto
import ru.vood.generator.datamodel.dataType.meta.type.*
import java.math.BigDecimal
import java.time.LocalDateTime

internal class DslTest {

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    private val GEN_STR =
        object : GenerateFieldValueFunction<ScoreDto, String?> {
            override fun invoke(entityTemplate: EntityTemplate<ScoreDto>, s: String): DataType<String?> {
                return StringType("${entityTemplate.id}_$s")
            }
        }

    @Test
    fun getName() {
        val string = MetaProperty(
            "riskSegmentOffline",
            GEN_STR
        )
        val number = MetaProperty(
            "number",
            object : GenerateFieldValueFunction<ScoreDto, BigDecimal?> {
                override fun invoke(
                    entityTemplate: EntityTemplate<ScoreDto>,
                    s: String
                ): DataType<BigDecimal?> {
                    return NumberType(BigDecimal(entityTemplate.id.hashCode() + s.hashCode()))
                }
            })
        val date = MetaProperty(
            "date",
            object : GenerateFieldValueFunction<ScoreDto, LocalDateTime?> {
                override fun invoke(
                    entityTemplate: EntityTemplate<ScoreDto>,
                    s: String
                ): DataType<LocalDateTime?> {
                    return DateType(
                        LocalDateTime
                            .of(1970, 1, 1, 12, 12)
                            .plusSeconds(entityTemplate.id.hashCode().toLong() + s.hashCode().toLong())
                    )
                }
            })
        val expected: MetaEnt<ScoreDto> = MetaEnt(
            name = "score",
            property = setOf(
                string,
                number,
                date,
            ),
        )

        val score by entity<ScoreDto> {
            val riskSegmentOffline by STRING withFun { et, pn -> StringTypeNotNull { "${et.id}_$pn" } }
            val number by NUMBER
            val date by DATE

            val refOtherEnt by ref<ScoreDto>()
            val setOtherEnt by set<ScoreDto>()
        }


        val score2 by entity<ScoreDto> {
            val riskSegmentOffline by STRING with { et, pn -> "${et.id}_$pn" }
            val number by number()
            val date by date()

            val refOtherEnt by ref<ScoreDto>()
            val setOtherEnt by set<ScoreDto>()
        }

        assertEquals(expected, score)
    }

}




