package ru.vood.generator.datamodel.templatedto.meta.lkc

import ru.vood.generator.datamodel.templatedto.dsl.MetaEntity
import ru.vood.generator.datamodel.templatedto.dsl.entity
import ru.vood.generator.datamodel.templatedto.dsl.genVal
import ru.vood.generator.datamodel.templatedto.dsl.StandardFunction.dictVal
import ru.vood.generator.datamodel.templatedto.dsl.StandardFunction.rangeVal
import java.math.BigDecimal

object LkcDataStructure {

    val listCrit = IntRange(1, 20).map { "crit_$it" }.toList()

    fun standardLkcMeta(): MetaEntity<String> {
        val score1 by entity<String> {
            val id by string() genVal { q, w -> q.id.value() }
//            val lkId by string() genVal { q, w -> q.id.value() }
            val crit_id by string() genVal dictVal(listCrit)

            val linkProbe by number() genVal rangeVal(BigDecimal(0), BigDecimal(100))

        }
        return score1
    }
}