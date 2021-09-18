package ru.vood.generator.datamodel.dataType.meta.dsl

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
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

    @Test
    fun getName() {


        val expected = MetaEnt<ScoreDto, StringTypeNotNull>(
            name = "score",
            setOf<MetaProperty<StringTypeNotNull, *>>(
                MetaProperty<StringTypeNotNull, LocalDateTime>("date",
                    object : GenerateFieldValueFunction<StringTypeNotNull, LocalDateTime> {
                        override fun invoke(
                            entityTemplate: EntityTemplate<StringTypeNotNull>,
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
                MetaProperty<StringTypeNotNull, BigDecimal>("number",
                    object : GenerateFieldValueFunction<StringTypeNotNull, BigDecimal> {
                        override fun invoke(
                            entityTemplate: EntityTemplate<StringTypeNotNull>,
                            propertyName: String
                        ): DataType<BigDecimal> {
                            return NumberType(BigDecimal(entityTemplate.id.hashCode() + propertyName.hashCode()))
                        }
                    }
                ),
                MetaProperty<StringTypeNotNull, String>(
                    "riskSegmentOffline",
                    object : GenerateFieldValueFunction<StringTypeNotNull, String> {
                        override fun invoke(
                            entityTemplate: EntityTemplate<StringTypeNotNull>,
                            propertyName: String
                        ): DataType<String> {
                            return StringTypeNotNull("${entityTemplate.id}_$propertyName")
                        }
                    }
                )
            )
        )

        val score by entity<ScoreDto, StringTypeNotNull> {
            val riskSegmentOffline by STRING with { et, pn -> "${et.id}_$pn" }
            val number by NUMBER with { et, pn -> BigDecimal(et.id.hashCode() + pn.hashCode()) }
            val date by DATE with { et, pn ->
                LocalDateTime
                    .of(1970, 1, 1, 12, 12)
                    .plusSeconds(et.id.hashCode().toLong() + pn.hashCode().toLong())
            }


        }




        assertEquals(expected.name, score.name)
        assertEquals(expected.property.map { it.name }.sorted(), score.property.map { it.name }.sorted())
        val scoreDto = ScoreDto("1")
        val exp: List<Any?> = expected.property.sortedBy { it.name }.map { it.function(scoreDto, it.name).value() }
        val map: List<Any?> = score.property.sortedBy { it.name }.map { it.function(scoreDto, it.name).value() }
        assertEquals(exp, map)

    }

}




