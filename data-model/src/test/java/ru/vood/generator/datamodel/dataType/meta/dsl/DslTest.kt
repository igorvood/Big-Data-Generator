package ru.vood.generator.datamodel.dataType.meta.dsl

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import ru.vood.generator.datamodel.dataType.meta.GenerateFieldValueFunction
import ru.vood.generator.datamodel.dataType.meta.MetaEnt
import ru.vood.generator.datamodel.dataType.meta.MetaProperty
import ru.vood.generator.datamodel.dataType.meta.score.ScoreDto
import ru.vood.generator.datamodel.dataType.meta.type.DataType
import ru.vood.generator.datamodel.dataType.meta.type.EntityTemplate
import ru.vood.generator.datamodel.dataType.meta.type.StringType

internal class DslTest {

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun getName() {
        val expected: MetaEnt<ScoreDto> = MetaEnt(
            name = "score",
            property = setOf(
                MetaProperty(
                    "riskSegmentOffline",
                    object : GenerateFieldValueFunction<ScoreDto> {
                        override fun invoke(entityTemplate: EntityTemplate<ScoreDto>, s: String): DataType<*> {
                            return StringType { "${entityTemplate.id}_$s" }
                        }
                    }
                )
            ),
        )

        val score by entity<ScoreDto> {
            val riskSegmentOffline by string()  //withFun {}//NOT NULL

//            riskSegmentOffline withFun {}

        }
        assertEquals(expected, score)
    }
}