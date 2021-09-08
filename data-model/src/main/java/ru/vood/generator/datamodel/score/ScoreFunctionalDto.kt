package ru.vood.generator.datamodel.score

import ru.vood.generator.datamodel.clu.CluFunctionalDto

class ScoreFunctionalDto(
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

    val verId: String by genStr
    val crmId: String by genStr
   /* val orgId: String by lazy { id }
    val inn: String by lazy { id }
    val eksId: String by lazy { id }
    val ucId: String by lazy { id }
    val mgId: String by lazy { id }
    val ogrn: String by lazy { id }
    val kpp: String by lazy { id }
    val okpo: String by lazy { id }
    val fullName: String by lazy { id }
    val shortName: String by lazy { id }
    val opf: String by lazy { id }
    val regDate: String by lazy { id }
    val regAddressPostalCode: String by lazy { id }
    val regAddressRegionName: String by lazy { id }
    val regAddressDistrictName: String by lazy { id }
    val regAddressCityName: String by lazy { id }
    val regAddressVillageName: String by lazy { id }
    val regAddressSVillageTypeName: String by lazy { id }
    val regAddressStreetName: String by lazy { id }
    val regAddressSStreetTypeName: String by lazy { id }
    val regAddressHouseNumber: String by lazy { id }
    val regAddressBuildingNumber: String by lazy { id }
    val regAddressBlockNumber: String by lazy { id }
    val regAddressFlatNumber: String by lazy { id }

    val oPhoneNumber: String by lazy { id }
    val mPhoneNumber: String by lazy { id }
    val email: String by lazy { id }

    val fAddressPostalCode: String by lazy { id }
    val fAddressRegionName: String by lazy { id }
    val fAddressDistrictName: String by lazy { id }
    val fAddressCityName: String by lazy { id }
    val fAddressVillageName: String by lazy { id }
    val fAddressSVillageTypeName: String by lazy { id }
    val fAddressStreetName: String by lazy { id }
    val fAddressSStreetTypeName: String by lazy { id }
    val fAddressHouseNumber: Int by lazy { id.hashCode() }
    val fAddressBuildingNumber: Int by lazy { id.hashCode() }
    val fAddressBlockNumber: String by lazy { id }
    val fAddressFlatNumber: String by lazy { id }

    val fax: String by lazy { id }
    val bSegment: String by lazy { id }
    val industry: String by lazy { id }
    val crmTopGSZId: String by lazy { id }
    val crmGSZId: String by lazy { id }*/

    val clu: Set<CluFunctionalDto> by lazy { IntRange(1, 2).map { CluFunctionalDto("""${id}_$it""", it.toString()) }.toSet() }

    companion object {

        //        val SCORE_HEADERS = ScoreMeta.values().map { it.name }.toSet()
        val q = ScoreFunctionalDto::class.members
            .map {
//                println(it)
                it
            }
    }

//    override fun headers() = SCORE_HEADERS
}

