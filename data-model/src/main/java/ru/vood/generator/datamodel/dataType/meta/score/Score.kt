package ru.vood.generator.datamodel.dataType.meta.score

import ru.vood.generator.datamodel.dataType.meta.dsl.MetaEntity
import ru.vood.generator.datamodel.dataType.meta.dsl.entity
import ru.vood.generator.datamodel.dataType.meta.dsl.genVal
import ru.vood.generator.datamodel.dataType.meta.type.EntityTemplate
import java.math.BigDecimal
import java.time.LocalDateTime

object Score {
    val genBool: (EntityTemplate<String>, String) -> Boolean =
        { et, pn -> "${et.id}_$pn".hashCode() % 2 != 0 }
    val genStr: (EntityTemplate<String>, String) -> String = { et, pn -> "${et.id}_$pn" }
    val genNum: (EntityTemplate<String>, String) -> BigDecimal =
        { et, pn -> BigDecimal(kotlin.math.abs(et.id.hashCode() + pn.hashCode())) }
    val dateFunction: (EntityTemplate<String>, String) -> LocalDateTime = { et, pn ->
        LocalDateTime
            .of(1970, 1, 1, 12, 12)
            .plusSeconds(et.id.hashCode().toLong() + pn.hashCode().toLong())
    }


    fun <T> stdStr(): (EntityTemplate<T>, String) -> String = { et, pn -> "${et.id.value()}_$pn" }
    fun <T> stdBool(): (EntityTemplate<T>, String) -> Boolean = { et, pn -> "${et.id.value()}_$pn".hashCode() % 2 != 0 }
    fun <T> stdNum(): (EntityTemplate<T>, String) -> BigDecimal =
        { et, pn -> BigDecimal(kotlin.math.abs(et.id.hashCode() + pn.hashCode())) }

    fun <T> stdDate(): (EntityTemplate<T>, String) -> LocalDateTime = { et, pn ->
        LocalDateTime
            .of(1970, 1, 1, 12, 12)
            .plusSeconds(et.id.hashCode().toLong() + pn.hashCode().toLong())
    }


    fun standardScoreMeta(): MetaEntity<String> {
        val score1 by entity<String> {
            val riskSegmentOffline by string() genVal stdStr()
            val riskSegmentOfflineDate by date() genVal stdDate()
            val merSign by bool() genVal stdBool()
            val thmSign by string() genVal stdStr()
            val mshFlg by string() genVal stdStr()
            val overCap by number() genVal stdNum()
            val wsRatingRestr by number() genVal stdNum()
            val ratingOffline by number() genVal stdNum()
            val ratingOfflinePrice by number() genVal stdNum()
            val ratingOfflineReserve by number() genVal stdNum()
            val cindex by number() genVal stdNum()
            val skeBase by number() genVal stdNum()
            val skeD0 by number() genVal stdNum()
            val skeOffline by number() genVal stdNum()
            val skeBcCap by number() genVal stdNum()
            val nonCurAssets by number() genVal stdNum()
            val opkFlag by number() genVal stdNum()
        }
        return score1
    }

}

