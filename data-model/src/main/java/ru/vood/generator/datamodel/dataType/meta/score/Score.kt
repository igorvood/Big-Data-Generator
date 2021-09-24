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


    fun <T> stdStr(): (EntityTemplate<T>, String) -> String = { et, pn -> "${et.id}_$pn" }


    fun standardMeta(): MetaEntity<String> {
        val score: MetaEntity<String> by entity<String> {

            val riskSegmentOffline by STRING genVal stdStr()
            val riskSegmentOfflineDate by DATE genVal dateFunction
            val merSign by BOOL genVal genBool
            val thmSign by STRING genVal genStr
            val mshFlg by STRING genVal genStr
            val overCap by NUMBER genVal genNum
            val wsRatingRestr by NUMBER genVal genNum
            val ratingOffline by NUMBER genVal genNum
            val ratingOfflinePrice by NUMBER genVal genNum
            val ratingOfflineReserve by NUMBER genVal genNum
            val cindex by NUMBER genVal genNum
            val skeBase by NUMBER genVal genNum
            val skeD0 by NUMBER genVal genNum
            val skeOffline by NUMBER genVal genNum
            val skeBcCap by NUMBER genVal genNum
            val nonCurAssets by NUMBER genVal genNum
            val opkFlag by NUMBER genVal genNum
        }
        return score
   }

}

