package ru.vood.generator.datamodel.dataType.meta.score

import ru.vood.generator.datamodel.dataType.meta.clu.CluDataStructure.standardCluMeta
import ru.vood.generator.datamodel.dataType.meta.clu.CluDto
import ru.vood.generator.datamodel.dataType.meta.clu.CluPk
import ru.vood.generator.datamodel.dataType.meta.dsl.MetaEntity
import ru.vood.generator.datamodel.dataType.meta.dsl.entity
import ru.vood.generator.datamodel.dataType.meta.dsl.genVal
import ru.vood.generator.datamodel.util.function.StandardFunction.genOneEntityData
import ru.vood.generator.datamodel.util.function.StandardFunction.stdBool
import ru.vood.generator.datamodel.util.function.StandardFunction.stdDate
import ru.vood.generator.datamodel.util.function.StandardFunction.stdNum
import ru.vood.generator.datamodel.util.function.StandardFunction.stdStr

object Score {
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

            val clu by ref<CluDto>() genVal { q, w ->
                genOneEntityData(standardCluMeta(), { CluPk("1", q) }, { pk, meta -> CluDto(pk, meta) })
            }

        }
        return score1
    }

}

