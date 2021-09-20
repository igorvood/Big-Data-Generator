package ru.vood.generator.datamodel.dataType.meta.dsl

import io.mockk.confirmVerified
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.vood.generator.datamodel.dataType.meta.score.ScoreDto
import ru.vood.generator.datamodel.dataType.meta.type.EntityTemplate
import ru.vood.generator.datamodel.dataType.meta.type.StringTypeNotNull
import java.math.BigDecimal
import java.time.LocalDateTime

class DslLasyTest {


    lateinit var riskSegmentOfflineFunction: (EntityTemplate<StringTypeNotNull>, String) -> String
    lateinit var numberFunction: (EntityTemplate<StringTypeNotNull>, String) -> BigDecimal
    lateinit var dateFunction: (EntityTemplate<StringTypeNotNull>, String) -> LocalDateTime

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


//    lateinit var checkF: (ScoreDto) -> Boolean

    @Test
    fun getName() {
        val score by entity<ScoreDto, StringTypeNotNull> {
            val riskSegmentOffline by STRING genVal riskSegmentOfflineFunction
            val number by NUMBER genVal numberFunction
            val date by DATE genVal dateFunction

            val checkFunction: (ScoreDto) -> Boolean =
                { number(it) > BigDecimal(0) && riskSegmentOffline(it) != "ОЧЕНЬ РИСКОВАННЫЙ СЕГМЕНТ" }

            val numGratherZeroCheck by check with checkFunction
        }
        confirmVerified(dateFunction, numberFunction, riskSegmentOfflineFunction)
        val scoreDto = ScoreDto("1")
        val b = score.ck.map { it.checkFunction(scoreDto) }[0]
        Assertions.assertEquals(true, b)
        verify {
            numberFunction(scoreDto, "number")
            riskSegmentOfflineFunction(scoreDto, "riskSegmentOffline")
        }
        confirmVerified(dateFunction, numberFunction, riskSegmentOfflineFunction)

    }
}