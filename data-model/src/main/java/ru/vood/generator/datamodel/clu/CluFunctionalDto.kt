package ru.vood.generator.datamodel.clu

import ru.vood.generator.datamodel.score.ValueString
import kotlin.reflect.KCallable


data class CluFunctionalDto(
    val scoreId: String,
    val id: String,

    ) {
    @Transient
    private val genStr = ValueString(id)

    val map: Map<String, Any?> by CluValueMap()

    val verId: String by genStr
    val verId1: String by genStr
    val verId10: String by genStr
    val verId11: String by genStr
    val verId12: String by genStr
    val verId13: String by genStr
    val verId14: String by genStr
    val verId15: String by genStr
    val verId16: String by genStr
    val verId17: String by genStr
    val verId18: String by genStr
    val verId19: String by genStr
    val verId2: String by genStr
    val verId20: String by genStr
    val verId21: String by genStr
    val verId22: String by genStr
    val verId23: String by genStr
    val verId24: String by genStr
    val verId25: String by genStr
    val verId26: String by genStr
    val verId27: String by genStr
    val verId28: String by genStr
    val verId29: String by genStr

    companion object {

        val fields: Set<KCallable<*>> = CluFunctionalDto::class.members
            .map {
                it
            }.toSet()
    }
}