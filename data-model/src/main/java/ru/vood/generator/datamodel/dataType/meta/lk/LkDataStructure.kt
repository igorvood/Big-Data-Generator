package ru.vood.generator.datamodel.dataType.meta.lk

import ru.vood.generator.datamodel.dataType.meta.dsl.MetaEntity
import ru.vood.generator.datamodel.dataType.meta.dsl.entity
import ru.vood.generator.datamodel.dataType.meta.dsl.genVal
import ru.vood.generator.datamodel.dataType.meta.lkc.LkcDataStructure.standardLkcMeta
import ru.vood.generator.datamodel.dataType.meta.lkc.LkcDto
import ru.vood.generator.datamodel.util.function.StandardFunction.genOneEntityData

object LkDataStructure {
    fun standardLkMeta(): MetaEntity<String> {
        val score1 by entity<String> {
            val id by string() genVal { q, w -> q.id.value() }
            val idFrom by string() genVal { et, p ->
                """${(et.id.value().hashCode() + p.hashCode())}_$p"""
            }
            val tFrom by string() genVal { et, p ->
                if ((et.id.value().hashCode() + p.hashCode()) % 2 == 0) "clu" else "clf"
            }
            val idTo by string() genVal { et, p ->
                """${(et.id.value().hashCode() + p.hashCode())}_$p"""
            }
            val tTo by string() genVal { et, p ->
                if ((et.id.value().hashCode() + p.hashCode()) % 2 == 0) "clu" else "clf"
            }

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