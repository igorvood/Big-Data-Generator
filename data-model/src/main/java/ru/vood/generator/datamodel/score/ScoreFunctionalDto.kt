package ru.vood.generator.datamodel.score

import ru.vood.generator.datamodel.clu.CluFunctionalDto
import ru.vood.generator.datamodel.util.GeneratedEntity
import java.time.LocalDateTime
import kotlin.reflect.KCallable
import kotlin.reflect.KProperty

data class ScoreFunctionalDto(
    val id: String,
) : GeneratedEntity<ScoreFunctionalDto> {

    val objectInMap: Map<String, Any> by objToMap()

    val riskSegmentOffline: String by valueStr(id)
    val riskSegmentOfflineDate: LocalDateTime by valueTime(id)

    val merSign: Boolean by valueBool(id)
    val thmSign: String by valueStr(id)
    val mshFlg: String by valueStr(id)
    val overCap: Int by valueNum(id)
    val wsRatingRestr: Int by valueNum(id)
    val ratingOffline: Int by valueNum(id)
    val ratingOfflinePrice: Int by valueNum(id)
    val ratingOfflineReserve: Int by valueNum(id)
    val cindex: Int by valueNum(id)
    val skeBase: Int by valueNum(id)
    val skeD0: Int by valueNum(id)
    val skeOffline: Int by valueNum(id)
    val skeBcCap: Int by valueNum(id)
    val nonCurAssets: Int by valueNum(id)
    val opkFlag: Int by valueNum(id)

    val clu: CluFunctionalDto by valueAny(id) { CluFunctionalDto("${it}_SCORE") }

    val clus: Set<CluFunctionalDto> by valueSetAny(id, 1, 20) { id, num -> CluFunctionalDto("""${id}_$num""") }


    override fun metaFields(): Set<KCallable<*>> = fields

    override fun objectInMap(): Map<String, Any> = objectInMap

    companion object {

        val fields: Set<KCallable<*>> by lazy {
            val toSet = ScoreFunctionalDto::class.members
                .filterIsInstance<KProperty<*>>()
                .toSet()
            toSet
        }


    }

}

