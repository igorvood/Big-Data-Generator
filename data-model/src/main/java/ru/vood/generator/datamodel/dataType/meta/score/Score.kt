package ru.vood.generator.datamodel.dataType.meta.score

import ru.vood.generator.datamodel.dataType.meta.client.CluDataStructure.standardCluMeta
import ru.vood.generator.datamodel.dataType.meta.client.CluDto
import ru.vood.generator.datamodel.dataType.meta.dsl.MetaEntity
import ru.vood.generator.datamodel.dataType.meta.dsl.entity
import ru.vood.generator.datamodel.dataType.meta.dsl.genVal
import ru.vood.generator.datamodel.dataType.meta.lk.LkDataStructure.standardLkMeta
import ru.vood.generator.datamodel.dataType.meta.lkc.LkcDto
import ru.vood.generator.datamodel.util.function.StandardFunction.genEntityData
import ru.vood.generator.datamodel.util.function.StandardFunction.genOneEntityData
import ru.vood.generator.datamodel.util.function.StandardFunction.stdBool
import ru.vood.generator.datamodel.util.function.StandardFunction.stdDate
import ru.vood.generator.datamodel.util.function.StandardFunction.stdNum
import ru.vood.generator.datamodel.util.function.StandardFunction.stdStr

object Score {
    fun standardScoreMeta(): MetaEntity<String> {
        val score1 by entity<String> {
            val id by string() genVal { q, w -> q.id.value() }
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

            val clu by ref<CluDto>() genVal { q, w ->
                genOneEntityData(standardCluMeta(), { "${id(q)}_SCORE" }, { pk, meta -> CluDto(pk, meta) })
            }

            val lks by set<LkcDto>() genVal { et, pn ->
                genEntityData(
                    standardLkMeta(),
                    { IntRange(1, 10).map { """${et.id.value()}_$it""" }.toSet() },
                    { pk, meta -> LkcDto(pk, meta) })
            }

        }
        return score1
    }

}

