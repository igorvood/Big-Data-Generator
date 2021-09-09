package ru.vood.generator.datamodel.clu

import ru.vood.generator.datamodel.util.FieldMeta
import ru.vood.generator.datamodel.util.GeneratedEntity
import java.time.LocalDateTime
import kotlin.reflect.KCallable


data class CluFunctionalDto(
    val scoreId: String,
    val id: String,
) : GeneratedEntity<CluFunctionalDto> {

    val crmId: String by valueStr(id)
    val orgId: String by valueStr(id)
    val inn: String by valueStr(id)
    val eksId: String by valueStr(id)
    val ucId: String by valueStr(id)
    val mgId: String by valueStr(id)
    val ogrn: String by valueStr(id)
    val kpp: String by valueStr(id)
    val okpo: String by valueStr(id)
    val fullName: String by valueStr(id)
    val shortName: String by valueStr(id)
    val opf: String by valueStr(id)
    val regDate: LocalDateTime by valueTime(id)
    val regAddressPostalCode: String by valueStr(id)
    val regAddressRegionName: String by valueStr(id)
    val regAddressDistrictName: String by valueStr(id)
    val regAddressCityName: String by valueStr(id)
    val regAddressVillageName: String by valueStr(id)
    val regAddressSVillageTypeName: String by valueStr(id)
    val regAddressStreetName: String by valueStr(id)
    val regAddressSStreetTypeName: String by valueStr(id)
    val regAddressHouseNumber: String by valueStr(id)
    val regAddressBuildingNumber: String by valueStr(id)
    val regAddressBlockNumber: String by valueStr(id)
    val regAddressFlatNumber: String by valueStr(id)

    val oPhoneNumber: String by valueStr(id)
    val mPhoneNumber: String by valueStr(id)
    val email: String by valueStr(id)

    val fAddressPostalCode: String by valueStr(id)
    val fAddressRegionName: String by valueStr(id)
    val fAddressDistrictName: String by valueStr(id)
    val fAddressCityName: String by valueStr(id)
    val fAddressVillageName: String by valueStr(id)
    val fAddressSVillageTypeName: String by valueStr(id)
    val fAddressStreetName: String by valueStr(id)
    val fAddressSStreetTypeName: String by valueStr(id)
    val fAddressHouseNumber: String by valueStr(id)
    val fAddressBuildingNumber: String by valueStr(id)
    val fAddressBlockNumber: String by valueStr(id)
    val fAddressFlatNumber: String by valueStr(id)

    val fax: String by valueStr(id)
    val bSegment: String by valueStr(id)
    val industry: String by valueStr(id)
    val crmTopGSZId: String by valueStr(id)
    val crmGSZId: String by valueStr(id)

    val objectInMap: Map<String, Any> by objToMap()

    override fun objectInMap(): Map<String, Any> = objectInMap

    override fun metaFields(): Set<KCallable<*>> = fields

    companion object {

        val fields: Set<KCallable<*>> = CluFunctionalDto::class.members
            .map {
                it
            }.toSet()

        val fieldsMeta: Map<String, FieldMeta> = fields
            .map {
                it.name to FieldMeta(it.name, it.returnType)
            }.toMap()
    }
}