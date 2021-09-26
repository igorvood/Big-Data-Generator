package ru.vood.generator.datamodel.templatedto.meta.lk

import ru.vood.generator.datamodel.templatedto.meta.client.ClfDataStructure.standardClfMeta
import ru.vood.generator.datamodel.templatedto.meta.client.ClfDto
import ru.vood.generator.datamodel.templatedto.meta.client.Client
import ru.vood.generator.datamodel.templatedto.meta.client.CluDataStructure.standardCluMeta
import ru.vood.generator.datamodel.templatedto.meta.client.CluDto
import ru.vood.generator.datamodel.templatedto.dsl.MetaEntity
import ru.vood.generator.datamodel.templatedto.dsl.entity
import ru.vood.generator.datamodel.templatedto.dsl.genVal
import ru.vood.generator.datamodel.templatedto.meta.lkc.LkcDataStructure.standardLkcMeta
import ru.vood.generator.datamodel.templatedto.meta.lkc.LkcDto
import ru.vood.generator.datamodel.templatedto.DataType
import ru.vood.generator.datamodel.templatedto.EntityTemplate
import ru.vood.generator.datamodel.templatedto.dsl.StandardFunction.dictVal
import ru.vood.generator.datamodel.templatedto.dsl.StandardFunction.genOneEntityData

object LkDataStructure {

    private const val CLU = "clu"
    private const val CLF = "clf"
    private val clTypes = listOf(CLU, CLF)

    private val genClientId: (EntityTemplate<String>, String) -> String = { et, p ->
        """${(et.id.value().hashCode() + p.hashCode())}_$p"""
    }

    private fun clientVal(
        fClType: (EntityTemplate<String>, String) -> DataType<String>,
        fId: (EntityTemplate<String>, String) -> DataType<String>
    ): (EntityTemplate<String>, String) -> Client =
        { et, pn ->
            when (val type = fClType(et, pn).value()) {
                CLU -> CluDto(fId(et, pn).value(), standardCluMeta())
                CLF -> ClfDto(fId(et, pn).value(), standardClfMeta())
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

            val idFromRef by ref<Client>() genVal clientVal(tFrom.function, idFrom.function)
            val idToRef by ref<Client>() genVal clientVal(tTo.function, idTo.function)
        }
        return score1
    }
}