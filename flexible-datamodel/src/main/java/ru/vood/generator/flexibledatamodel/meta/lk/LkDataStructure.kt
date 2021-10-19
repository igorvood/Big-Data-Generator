package ru.vood.generator.flexibledatamodel.meta.lk

import ru.vood.generator.flexibledatamodel.meta.lkc.LkcDataStructure.standardLkcMeta
import ru.vood.generator.flexibledatamodel.meta.lkc.LkcDto
import ru.vood.generator.flexibledatamodel.dsl.EntityTemplate
import ru.vood.generator.flexibledatamodel.dsl.*
import ru.vood.generator.flexibledatamodel.dsl.StandardFunction.dictVal
import ru.vood.generator.flexibledatamodel.dsl.StandardFunction.genOneEntityData
import ru.vood.generator.flexibledatamodel.meta.client.ClfDataStructure.standardClfMeta
import ru.vood.generator.flexibledatamodel.meta.client.ClfDto
import ru.vood.generator.flexibledatamodel.meta.client.Client
import ru.vood.generator.flexibledatamodel.meta.client.CluDataStructure.standardCluMeta
import ru.vood.generator.flexibledatamodel.meta.client.CluDto

object LkDataStructure {

    private const val CLU = "clu"
    private const val CLF = "clf"
    private val clTypes = listOf(CLU, CLF)

    private val genClientId: (EntityTemplate<String>, String) -> String = { et, p ->
        """${(et.id.value().hashCode() + p.hashCode())}_$p"""
    }

    private fun clientVal(
        typeClientProp: MetaProperty<String, String>,
        idFrom1: MetaProperty<String, String>
    ): (EntityTemplate<String>, String) -> Client = { et, pn ->
        when (val type = typeClientProp(et)) {
            CLU -> CluDto(idFrom1(et), standardCluMeta())
            CLF -> ClfDto(idFrom1(et), standardClfMeta())
            else -> error("тип $type не поддерживается")
        }
    }


    fun standardLkMeta(): MetaEntity<String> {
        val score1 by entity<String> {
            val id by string() genVal { q, w -> q.id.value() }

            val idFrom by string() genVal genClientId
            val tFrom by string() genVal dictVal(clTypes)
            val idTo by string() genVal genClientId
            val tTo by string() genVal dictVal(clTypes)


            val lkc by ref<LkcDto>() genVal { et, p ->
                genOneEntityData(
                    standardLkcMeta(),
                    { id(et) },
                    { pk, meta -> LkcDto(pk, meta) })
            }

            //            val idFromRef by ref<Client>() genVal clientVal(tFrom.function, idFrom.function)


            val idFromRef by ref<Client>() genVal clientVal(tFrom, idFrom)
            val idToRef by ref<Client>() genVal clientVal(tTo, idTo)

            val ckIdFromRef by check with { et ->
                idFrom(et) == idFromRef(et).id.value()
            }
            val ckIdToRef by check with { et ->
                idTo(et) == idToRef(et).id.value()
            }

        }
        return score1
    }
}