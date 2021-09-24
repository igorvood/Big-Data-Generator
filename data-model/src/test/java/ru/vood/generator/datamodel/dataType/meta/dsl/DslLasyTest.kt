package ru.vood.generator.datamodel.dataType.meta.dsl

import io.mockk.confirmVerified
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.vood.generator.datamodel.dataType.meta.score.ScoreDto
import ru.vood.generator.datamodel.dataType.meta.type.EntityTemplate
import java.math.BigDecimal
import java.time.LocalDateTime

class DslLasyTest {


    lateinit var riskSegmentOfflineFunction: (EntityTemplate<String>, String) -> String
    lateinit var numberFunction: (EntityTemplate<String>, String) -> BigDecimal
    lateinit var dateFunction: (EntityTemplate<String>, String) -> LocalDateTime

    @BeforeEach
    fun setUp() {
        riskSegmentOfflineFunction = spyk({ et, pn -> "${et.id}_$pn" })
        numberFunction = spyk({ et, pn -> BigDecimal(kotlin.math.abs(et.id.hashCode() + pn.hashCode())) })
        dateFunction = spyk({ et, pn ->
            LocalDateTime
                .of(1970, 1, 1, 12, 12)
                .plusSeconds(et.id.hashCode().toLong() + pn.hashCode().toLong())
        })
    }

    @Test
    fun getName() {
        val score by entity<String> {
            val riskSegmentOffline by string() genVal riskSegmentOfflineFunction
            val number by number() genVal numberFunction
            val date by date() genVal dateFunction

            val numGatherZeroCheck by check with {
                number(it) > BigDecimal(0) && riskSegmentOffline(it) != "ОЧЕНЬ РИСКОВАННЫЙ СЕГМЕНТ"
            }
        }
        confirmVerified(dateFunction, numberFunction, riskSegmentOfflineFunction)
        val scoreDto: EntityTemplate<String> = ScoreDto("1", score)
        val b = score.ck.map { it.checkFunction(scoreDto) }[0]
        Assertions.assertEquals(true, b)
        verify {
            numberFunction(scoreDto, "number")
            riskSegmentOfflineFunction(scoreDto, "riskSegmentOffline")
        }
        confirmVerified(dateFunction, numberFunction, riskSegmentOfflineFunction)

    }
}