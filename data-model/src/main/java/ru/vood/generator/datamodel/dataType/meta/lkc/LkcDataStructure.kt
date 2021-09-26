package ru.vood.generator.datamodel.dataType.meta.lkc

import ru.vood.generator.datamodel.dataType.meta.dsl.MetaEntity
import ru.vood.generator.datamodel.dataType.meta.dsl.entity
import ru.vood.generator.datamodel.dataType.meta.dsl.genVal

object LkcDataStructure {

    val listCrit = IntRange(1, 20).map { "crit_$it" }.toList()

    fun standardLkcMeta(): MetaEntity<String> {
        val score1 by entity<String> {
            val id by string() genVal { q, w -> q.id.value() }
//            val lkId by string() genVal { q, w -> q.id.value() }
            val crit_id by string() genVal { et, pn ->
                val i = kotlin.math.abs(et.id.value().hashCode() + pn.hashCode()) % listCrit.size
                listCrit[i]
            }

            val linkProbe by number() genVal { et, pn ->
                (kotlin.math.abs(et.id.value().hashCode() + pn.hashCode()) % 100).toBigDecimal()
            }

        }
        return score1
    }
}