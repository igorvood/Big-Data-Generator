package ru.vood.generator.datamodel.dataType.meta.lk

import ru.vood.generator.datamodel.dataType.meta.dsl.MetaEntity
import ru.vood.generator.datamodel.dataType.meta.dsl.entity
import ru.vood.generator.datamodel.dataType.meta.dsl.genVal
import ru.vood.generator.datamodel.dataType.meta.lkc.LkcDataStructure
import ru.vood.generator.datamodel.dataType.meta.lkc.LkcDataStructure.standardLkcMeta
import ru.vood.generator.datamodel.dataType.meta.lkc.LkcDto
import ru.vood.generator.datamodel.util.function.StandardFunction
import ru.vood.generator.datamodel.util.function.StandardFunction.dictVal
import ru.vood.generator.datamodel.util.function.StandardFunction.genOneEntityData

object LkDataStructure {

    val clTypes = listOf("clu", "clf")

    fun standardLkMeta(): MetaEntity<String> {
        val score1 by entity<String> {
            val id by string() genVal { q, w -> q.id.value() }
            val idFrom by string() genVal { et, p ->
                """${(et.id.value().hashCode() + p.hashCode())}_$p"""
            }
            val tFrom by string() genVal dictVal(clTypes)
            val idTo by string() genVal { et, p ->
                """${(et.id.value().hashCode() + p.hashCode())}_$p"""
            }
            val tTo by string() genVal dictVal(clTypes)

            val lkc by ref<LkcDto>() genVal { et, p ->
                genOneEntityData(
                    standardLkcMeta(),
                    { id(et) },
                    { pk, meta -> LkcDto(pk, meta) })
            }

        }
        return score1
    }
}