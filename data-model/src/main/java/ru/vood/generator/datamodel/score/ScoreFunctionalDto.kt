package ru.vood.generator.datamodel.score

import ru.vood.generator.datamodel.clu.CluFunctionalDto
import ru.vood.generator.datamodel.util.GeneratedEntity
import java.time.LocalDateTime
import kotlin.reflect.KCallable

data class ScoreFunctionalDto(
    val id: String,
) : GeneratedEntity<ScoreFunctionalDto> {
//    @Transient
//    private val genStr = ValueString(id)
//    @Transient
//    private val genNum = ValueNum(id)
//    @Transient
//    private val genBool = ValueBoolean(id)

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


    val clu: Set<CluFunctionalDto> by lazy {
        IntRange(1, 200).map { CluFunctionalDto("""${id}_$it""", it.toString()) }.toSet()
    }
    val clu1: Set<CluFunctionalDto> by lazy {
        IntRange(1, 200).map { CluFunctionalDto("""${id}_$it""", it.toString()) }.toSet()
    }
    val clu2: Set<CluFunctionalDto> by lazy {
        IntRange(1, 200).map { CluFunctionalDto("""${id}_$it""", it.toString()) }.toSet()
    }
    val clu3: Set<CluFunctionalDto> by lazy {
        IntRange(1, 200).map { CluFunctionalDto("""${id}_$it""", it.toString()) }.toSet()
    }
    val clu4: Set<CluFunctionalDto> by lazy {
        IntRange(1, 200).map { CluFunctionalDto("""${id}_$it""", it.toString()) }.toSet()
    }
    val clu5: Set<CluFunctionalDto> by lazy {
        IntRange(1, 200).map { CluFunctionalDto("""${id}_$it""", it.toString()) }.toSet()
    }
    val clu6: Set<CluFunctionalDto> by lazy {
        IntRange(1, 200).map { CluFunctionalDto("""${id}_$it""", it.toString()) }.toSet()
    }
    val clu7: Set<CluFunctionalDto> by lazy {
        IntRange(1, 200).map { CluFunctionalDto("""${id}_$it""", it.toString()) }.toSet()
    }

    override fun metaFields(): Set<KCallable<*>> = fields

    override fun objectInMap(): Map<String, Any> = objectInMap

    companion object {

        val fields: Set<KCallable<*>> = ScoreFunctionalDto::class.members
            .map {
                it
            }.toSet()
    }

//    override fun headers() = SCORE_HEADERS
}

