package ru.vood.generator.datamodel.dataType.meta.dsl

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.vood.generator.datamodel.dataType.meta.score.ScoreDto
import ru.vood.generator.datamodel.dataType.meta.type.*
import java.math.BigDecimal
import java.time.LocalDateTime

internal class DslFieldTest {

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun getName() {


        val expected = MetaEntity<String>(
            name = "score",
            property = setOf<MetaProperty<String, *>>(
                MetaProperty<String, LocalDateTime>("date",
                    object : GenerateFieldValueFunction<String,DataType< LocalDateTime>> {
                        override fun invoke(
                            entityTemplate: EntityTemplate<String>,
                            propertyName: String
                        ): DataType<LocalDateTime> {
                            return DateType(
                                LocalDateTime
                                    .of(1970, 1, 1, 12, 12)
                                    .plusSeconds(
                                        entityTemplate.id.hashCode().toLong() + propertyName.hashCode().toLong()
                                    )
                            )
                        }
                    }
                ),
                MetaProperty<String, BigDecimal>("number",
                    object : GenerateFieldValueFunction<String, DataType<BigDecimal>> {
                        override fun invoke(
                            entityTemplate: EntityTemplate<String>,
                            propertyName: String
                        ): DataType<BigDecimal> {
                            return NumberType(BigDecimal(entityTemplate.id.hashCode() + propertyName.hashCode()))
                        }
                    }
                ),
                MetaProperty<String, String>(
                    "riskSegmentOffline",
                    object : GenerateFieldValueFunction<String, DataType<String>> {
                        override fun invoke(
                            entityTemplate: EntityTemplate<String>,
                            propertyName: String
                        ): DataType<String> {
                            return StringTypeNotNull("${entityTemplate.id}_$propertyName")
                        }
                    }
                )
            ),
        )

        val score by entity<String> {
            val riskSegmentOffline by string() genVal { et, pn -> "${et.id}_$pn" }
            val number by number() genVal { et, pn -> BigDecimal(et.id.hashCode() + pn.hashCode()) }
            val date by date() genVal { et, pn ->
                LocalDateTime
                    .of(1970, 1, 1, 12, 12)
                    .plusSeconds(et.id.hashCode().toLong() + pn.hashCode().toLong())
            }

//            val numGratherZeroCheck by check with { number(it) > BigDecimal(0) && riskSegmentOffline(it)!="ОЧЕНЬ РИСКОВАННЫЙ СЕГМЕНТ" }
        }

        assertEquals(expected.name, score.name)
        assertEquals(expected.property.map { it.name }.sorted(), score.property.map { it.name }.sorted())
        val scoreDto = ScoreDto("1",score)
        val exp: List<Any?> = expected.property.sortedBy { it.name }.map { it.function(scoreDto, it.name).value() }
        val map: List<Any?> = score.property.sortedBy { it.name }.map { it.function(scoreDto, it.name).value() }

        assertEquals(exp, map)

//        assertEquals(expected.ck.map { it.name  }.sorted(), score.ck.map { it.name  }.sorted())


    }

}




