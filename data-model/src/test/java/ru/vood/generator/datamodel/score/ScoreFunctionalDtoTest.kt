package ru.vood.generator.datamodel.score

import io.mockk.confirmVerified
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.vood.generator.datamodel.util.FieldMeta

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

    @Test
    fun onlyMeta() {
        val cindex = scoreFunctionalDtoTest.metaFields()

        verify(exactly = 1) {
            scoreFunctionalDtoTest.metaFields()
        }
        confirmVerified(scoreFunctionalDtoTest)
    }

    @Test
    fun onlyMeta2() {
        val meta: Map<String, FieldMeta> = scoreFunctionalDtoTest.fieldsMetaMap()

        verify(exactly = 1) {
            scoreFunctionalDtoTest.fieldsMetaMap()
        }
        confirmVerified(scoreFunctionalDtoTest)

        Assertions.assertTrue(meta.keys.minus(fields.keys).isEmpty()) { meta.keys.minus(fields.keys).toString() }

        Assertions.assertTrue(fields.keys.minus(meta.keys).isEmpty()) { fields.keys.minus(meta.keys).toString() }

    }

    companion object {
        val fields = mapOf(
            "cindex" to 1,
            "objectInMap" to 1,
            "clu" to 1,
            "cluParticipants" to 1,
            "id" to 1,
            "merSign" to 1,
            "mshFlg" to 1,
            "nonCurAssets" to 1,
            "opkFlag" to 1,
            "overCap" to 1,
            "ratingOffline" to 1,
            "ratingOfflinePrice" to 1,
            "ratingOfflineReserve" to 1,
            "riskSegmentOffline" to 1,
            "riskSegmentOfflineDate" to 1,
            "skeBase" to 1,
            "skeBcCap" to 1,
            "skeD0" to 1,
            "skeOffline" to 1,
            "thmSign" to 1,
            "wsRatingRestr" to 1,

            )
    }
}