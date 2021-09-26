package ru.vood.generator.datamodel.dataType.meta.lkc

import ru.vood.generator.datamodel.dataType.meta.dsl.MetaEntity
import ru.vood.generator.datamodel.dataType.meta.dsl.entity
import ru.vood.generator.datamodel.dataType.meta.dsl.genVal
import ru.vood.generator.datamodel.util.function.StandardFunction.dictVal
import ru.vood.generator.datamodel.util.function.StandardFunction.rangeVal
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