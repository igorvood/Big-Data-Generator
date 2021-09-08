package ru.vood.generator.datamodel.score

import ru.vood.generator.datamodel.clu.CluFunctionalDto
import kotlin.reflect.KCallable

data class ScoreFunctionalDto(
    val id: String,
) {

    /*  val verId: (String) -> String = { it }
      val crmId: (String) -> String = { it }
      val orgId: (String) -> String = { it }
      val inn: (String) -> String = { it }
      val eksId: (String) -> String = { it }
      val ucId: (String) -> String = { it }
      val mgId: (String) -> String = { it }
      val ogrn: (String) -> String = { it }
      val kpp: (String) -> String = { it }
      val okpo: (String) -> String = { it }
      val fullName: (String) -> String = { it }
      val shortName: (String) -> String = { it }
      val opf: (String) -> String = { it }
      val regDate: (String) -> Date = { Date() }
      val regAddressPostalCode: (String) -> String = { it }
      val regAddressRegionName: (String) -> String = { it }
      val regAddressDistrictName: (String) -> String = { it }
      val regAddressCityName: (String) -> String = { it }
      val regAddressVillageName: (String) -> String = { it }
      val regAddressSVillageTypeName: (String) -> String = { it }
      val regAddressStreetName: (String) -> String = { it }
      val regAddressSStreetTypeName: (String) -> String = { it }
      val regAddressHouseNumber: (Int) -> String = { it.toString() }
      val regAddressBuildingNumber: (Int) -> String = { it.toString() }
      val regAddressBlockNumber: (String) -> String = { it }
      val regAddressFlatNumber: (String) -> String = { it }

      val oPhoneNumber: (String) -> String = { it }
      val mPhoneNumber: (String) -> String = { it }
      val email: (String) -> String = { it }

      val fAddressPostalCode: (String) -> String = { it }
      val fAddressRegionName: (String) -> String = { it }
      val fAddressDistrictName: (String) -> String = { it }
      val fAddressCityName: (String) -> String = { it }
      val fAddressVillageName: (String) -> String = { it }
      val fAddressSVillageTypeName: (String) -> String = { it }
      val fAddressStreetName: (String) -> String = { it }
      val fAddressSStreetTypeName: (String) -> String = { it }
      val fAddressHouseNumber: (Int) -> String = { it.toString() }
      val fAddressBuildingNumber: (Int) -> String = { it.toString() }
      val fAddressBlockNumber: (String) -> String = { it }
      val fAddressFlatNumber: (String) -> String = { it }

      val fax: (String) -> String = { it }
      val bSegment: (String) -> String = { it }
      val industry: (String) -> String = { it }
      val crmTopGSZId: (String) -> String = { it }
      val crmGSZId: (String) -> String = { it }*/
    @Transient
    private val genStr = ValueString(id)

    val map: Map<String, Any?> by ScoreValueMap()

    val verId: String by genStr
    val crmId: String by genStr
    val orgId: String by genStr
    val inn: String by genStr
    val eksId: String by genStr
    val ucId: String by genStr
    val mgId: String by genStr
    val ogrn: String by genStr
    val kpp: String by genStr
    val okpo: String by genStr
    val fullName: String by genStr
    val shortName: String by genStr
    val opf: String by genStr
    val regDate: String by genStr
    val regAddressPostalCode: String by genStr
    val regAddressRegionName: String by genStr
    val regAddressDistrictName: String by genStr
    val regAddressCityName: String by genStr
    val regAddressVillageName: String by genStr
    val regAddressSVillageTypeName: String by genStr
    val regAddressStreetName: String by genStr
    val regAddressSStreetTypeName: String by genStr
    val regAddressHouseNumber: String by genStr
    val regAddressBuildingNumber: String by genStr
    val regAddressBlockNumber: String by genStr
    val regAddressFlatNumber: String by genStr

    val oPhoneNumber: String by genStr
    val mPhoneNumber: String by genStr
    val email: String by genStr

    val fAddressPostalCode: String by genStr
    val fAddressRegionName: String by genStr
    val fAddressDistrictName: String by genStr
    val fAddressCityName: String by genStr
    val fAddressVillageName: String by genStr
    val fAddressSVillageTypeName: String by genStr
    val fAddressStreetName: String by genStr
    val fAddressSStreetTypeName: String by genStr
    val fAddressHouseNumber: Int by lazy { id.hashCode() }
    val fAddressBuildingNumber: Int by lazy { id.hashCode() }
    val fAddressBlockNumber: String by genStr
    val fAddressFlatNumber: String by genStr

    val fax: String by genStr
    val bSegment: String by genStr
    val industry: String by genStr
    val crmTopGSZId: String by genStr
    val crmGSZId: String by genStr

    val clu: Set<CluFunctionalDto> by lazy { IntRange(1, 200).map { CluFunctionalDto("""${id}_$it""", it.toString()) }.toSet() }
    val clu1: Set<CluFunctionalDto> by lazy { IntRange(1, 200).map { CluFunctionalDto("""${id}_$it""", it.toString()) }.toSet() }
    val clu2: Set<CluFunctionalDto> by lazy { IntRange(1, 200).map { CluFunctionalDto("""${id}_$it""", it.toString()) }.toSet() }
    val clu3: Set<CluFunctionalDto> by lazy { IntRange(1, 200).map { CluFunctionalDto("""${id}_$it""", it.toString()) }.toSet() }
    val clu4: Set<CluFunctionalDto> by lazy { IntRange(1, 200).map { CluFunctionalDto("""${id}_$it""", it.toString()) }.toSet() }
    val clu5: Set<CluFunctionalDto> by lazy { IntRange(1, 200).map { CluFunctionalDto("""${id}_$it""", it.toString()) }.toSet() }
    val clu6: Set<CluFunctionalDto> by lazy { IntRange(1, 200).map { CluFunctionalDto("""${id}_$it""", it.toString()) }.toSet() }
    val clu7: Set<CluFunctionalDto> by lazy { IntRange(1, 200).map { CluFunctionalDto("""${id}_$it""", it.toString()) }.toSet() }

    companion object {

        val fields: Set<KCallable<*>> = ScoreFunctionalDto::class.members
            .map {
                it
            }.toSet()
    }

//    override fun headers() = SCORE_HEADERS
}

