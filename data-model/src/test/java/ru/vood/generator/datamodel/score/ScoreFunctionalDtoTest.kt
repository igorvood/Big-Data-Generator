package ru.vood.generator.datamodel.score

import io.mockk.confirmVerified
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class ScoreFunctionalDtoTest {

    lateinit var scoreFunctionalDtoTest: ScoreFunctionalDto

    @BeforeEach
    fun setUp() {
        scoreFunctionalDtoTest = spyk(ScoreFunctionalDto("5"))
    }

    @Test
    fun lazyTest() {
        confirmVerified(scoreFunctionalDtoTest)
    }

    @Test
    fun onlyOneFieldTest() {
        val cindex = scoreFunctionalDtoTest.cindex

        verify(exactly = 1) {
            scoreFunctionalDtoTest.cindex
        }
        confirmVerified(scoreFunctionalDtoTest)
    }

    @Test
    fun onlyAllFieldTest() {
        val cindex = scoreFunctionalDtoTest.objectInMap

        verify(exactly = 1) {
            scoreFunctionalDtoTest.cindex
            scoreFunctionalDtoTest.objectInMap
            scoreFunctionalDtoTest.metaFields()
            scoreFunctionalDtoTest.clu
            scoreFunctionalDtoTest.cluParticipants
            scoreFunctionalDtoTest.id
            scoreFunctionalDtoTest.merSign
            scoreFunctionalDtoTest.mshFlg
            scoreFunctionalDtoTest.nonCurAssets
            scoreFunctionalDtoTest.opkFlag
            scoreFunctionalDtoTest.overCap
            scoreFunctionalDtoTest.ratingOffline
            scoreFunctionalDtoTest.ratingOfflinePrice
            scoreFunctionalDtoTest.ratingOfflineReserve
            scoreFunctionalDtoTest.riskSegmentOffline
            scoreFunctionalDtoTest.riskSegmentOfflineDate
            scoreFunctionalDtoTest.skeBase
            scoreFunctionalDtoTest.skeBcCap
            scoreFunctionalDtoTest.skeD0
            scoreFunctionalDtoTest.skeOffline
            scoreFunctionalDtoTest.thmSign
            scoreFunctionalDtoTest.wsRatingRestr
        }
        confirmVerified(scoreFunctionalDtoTest)
    }

/*    @org.junit.jupiter.api.Test
    fun metaFields() {
    }

    @org.junit.jupiter.api.Test
    fun objectInMap() {
    }

    @org.junit.jupiter.api.Test
    fun fieldsMetaMap() {
    }*/
}