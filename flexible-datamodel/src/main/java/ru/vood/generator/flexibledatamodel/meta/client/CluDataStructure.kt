package ru.vood.generator.flexibledatamodel.meta.client

import ru.vood.generator.flexibledatamodel.dsl.MetaEntity
import ru.vood.generator.flexibledatamodel.dsl.StandardFunction.stdDate
import ru.vood.generator.flexibledatamodel.dsl.StandardFunction.stdStr
import ru.vood.generator.flexibledatamodel.dsl.entity
import ru.vood.generator.flexibledatamodel.dsl.genVal

object CluDataStructure {

    fun standardCluMeta(): MetaEntity<String> {
        val score1 by entity<String> {
            val crmId by string() genVal stdStr()
            val orgId by string() genVal stdStr()
            val inn by string() genVal stdStr()
            val eksId by string() genVal stdStr()
            val ucId by string() genVal stdStr()
            val mgId by string() genVal stdStr()
            val ogrn by string() genVal stdStr()
            val kpp by string() genVal stdStr()
            val okpo by string() genVal stdStr()
            val fullName by string() genVal stdStr()
            val shortName by string() genVal stdStr()
            val opf by string() genVal stdStr()
            val regDate by date() genVal stdDate()
            val regAddressPostalCode by string() genVal stdStr()
            val regAddressRegionName by string() genVal stdStr()
            val regAddressDistrictName by string() genVal stdStr()
            val regAddressCityName by string() genVal stdStr()
            val regAddressVillageName by string() genVal stdStr()
            val regAddressSVillageTypeName by string() genVal stdStr()
            val regAddressStreetName by string() genVal stdStr()
            val regAddressSStreetTypeName by string() genVal stdStr()
            val regAddressHouseNumber by string() genVal stdStr()
            val regAddressBuildingNumber by string() genVal stdStr()
            val regAddressBlockNumber by string() genVal stdStr()
            val regAddressFlatNumber by string() genVal stdStr()

            val oPhoneNumber by string() genVal stdStr()
            val mPhoneNumber by string() genVal stdStr()
            val email by string() genVal stdStr()

            val fAddressPostalCode by string() genVal stdStr()
            val fAddressRegionName by string() genVal stdStr()
            val fAddressDistrictName by string() genVal stdStr()
            val fAddressCityName by string() genVal stdStr()
            val fAddressVillageName by string() genVal stdStr()
            val fAddressSVillageTypeName by string() genVal stdStr()
            val fAddressStreetName by string() genVal stdStr()
            val fAddressSStreetTypeName by string() genVal stdStr()
            val fAddressHouseNumber by string() genVal stdStr()
            val fAddressBuildingNumber by string() genVal stdStr()
            val fAddressBlockNumber by string() genVal stdStr()
            val fAddressFlatNumber by string() genVal stdStr()

            val fax by string() genVal stdStr()
            val bSegment by string() genVal stdStr()
            val industry by string() genVal stdStr()
            val crmTopGSZId by string() genVal stdStr()
            val crmGSZId by string() genVal stdStr()

        }
        return score1
    }
}