package ru.vood.generator.datamodel.score

import io.mockk.confirmVerified
import io.mockk.spyk
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import ru.vood.generator.datamodel.util.FieldMeta

internal class ScoreFunctionalDtoTest {

    lateinit var score: ScoreFunctionalDto

    @BeforeEach
    fun setUp() {
        score = spyk(ScoreFunctionalDto("5"))
    }

    @Test
    fun foreignScoreToclu() {
        Assertions.assertEquals(score.id, score.clu.id)
        verify(exactly = 1) {
            score.id
            score.clu
        }
        confirmVerified(score)
    }

    @Test
    fun lazyTest() {
        confirmVerified(score)
    }

    @Test
    fun onlyOneFieldTest() {
        val cindex = score.cindex

        verify(exactly = 1) {
            score.cindex
        }
        confirmVerified(score)
    }

    @Test
    fun onlyAllFieldTest() {
        val cindex = score.objectInMap

        verify(exactly = 1) {
            score.cindex
            score.objectInMap
            score.metaFields()
            score.clu
            score.cluParticipants
            score.id
            score.merSign
            score.mshFlg
            score.nonCurAssets
            score.opkFlag
            score.overCap
            score.ratingOffline
            score.ratingOfflinePrice
            score.ratingOfflineReserve
            score.riskSegmentOffline
            score.riskSegmentOfflineDate
            score.skeBase
            score.skeBcCap
            score.skeD0
            score.skeOffline
            score.thmSign
            score.wsRatingRestr
        }
        confirmVerified(score)
    }

    @Test
    fun onlyMeta() {
        val cindex = score.metaFields()

        verify(exactly = 1) {
            score.metaFields()
        }
        confirmVerified(score)
    }

    @Test
    fun onlyMeta2() {
        val meta: Map<String, FieldMeta> = score.fieldsMetaMap()

        verify(exactly = 1) {
            score.fieldsMetaMap()
        }
        confirmVerified(score)

        Assertions.assertTrue(meta.keys.minus(fields.keys).isEmpty()) { meta.keys.minus(fields.keys).toString() }

        Assertions.assertTrue(fields.keys.minus(meta.keys).isEmpty()) { fields.keys.minus(meta.keys).toString() }

    }

    companion object {
        val fields by lazy {
            mapOf(
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
}