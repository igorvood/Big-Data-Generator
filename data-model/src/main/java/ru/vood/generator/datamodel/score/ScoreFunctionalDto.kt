package ru.vood.generator.datamodel.score

import org.apache.commons.logging.LogFactory
import ru.vood.generator.datamodel.clu.CluFunctionalDto
import ru.vood.generator.datamodel.util.FieldMeta
import ru.vood.generator.datamodel.util.GeneratedEntity
import ru.vood.generator.datamodel.util.dataFields
import java.time.LocalDateTime
import kotlin.reflect.KCallable

data class ScoreFunctionalDto(
    val id: String,
) : GeneratedEntity<ScoreFunctionalDto> {
    private val log = LogFactory.getLog(ScoreFunctionalDto::class.java)
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

    val clu: CluFunctionalDto by valueAny(id) { CluFunctionalDto(it) }

    val cluParticipants: Set<CluFunctionalDto> by valueSetAny(
        id,
        1,
        20
    ) { id, num -> CluFunctionalDto("""${id}_$num""") }

    override fun objectInMap(): Map<String, Any> = objectInMap

    override fun metaFields(): Set<KCallable<*>> = fieldsMetaKotlin

    override fun fieldsMetaMap(): Map<String, FieldMeta> = fieldsMetaMap

    companion object {

        val fieldsMetaKotlin: Set<KCallable<*>> = dataFields<ScoreFunctionalDto>()

        val fieldsMetaMap: Map<String, FieldMeta> = fieldsMetaKotlin.associate {
            it.name to FieldMeta(it.name, it.returnType)
        }

    }

}

