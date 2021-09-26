package ru.vood.generator.datamodel.util.function

import ru.vood.generator.datamodel.dataType.meta.dsl.MetaEntity
import ru.vood.generator.datamodel.dataType.meta.type.EntityTemplate
import java.math.BigDecimal
import java.time.LocalDateTime
import kotlin.math.abs

object StandardFunction {
    val genBool: (EntityTemplate<String>, String) -> Boolean =
        { et, pn -> "${et.id}_$pn".hashCode() % 2 != 0 }
    val genStr: (EntityTemplate<String>, String) -> String = { et, pn -> "${et.id}_$pn" }
    val genNum: (EntityTemplate<String>, String) -> BigDecimal =
        { et, pn -> BigDecimal(abs(et.id.hashCode() + pn.hashCode())) }
    val dateFunction: (EntityTemplate<String>, String) -> LocalDateTime = { et, pn ->
        LocalDateTime
            .of(1970, 1, 1, 12, 12)
            .plusSeconds(et.id.hashCode().toLong() + pn.hashCode().toLong())
    }


    fun <T> stdStr(): (EntityTemplate<T>, String) -> String = { et, pn -> "${et.id.value()}_$pn" }
    fun <T> stdBool(): (EntityTemplate<T>, String) -> Boolean = { et, pn -> "${et.id.value()}_$pn".hashCode() % 2 != 0 }
    fun <T> stdNum(): (EntityTemplate<T>, String) -> BigDecimal =
        { et, pn -> BigDecimal(abs(et.id.hashCode() + pn.hashCode())) }

    fun <T> stdDate(): (EntityTemplate<T>, String) -> LocalDateTime = { et, pn ->
        LocalDateTime
            .of(1970, 1, 1, 12, 12)
            .plusSeconds(et.id.hashCode().toLong() + pn.hashCode().toLong())
    }

    inline fun <reified ID_TYPE, reified T> genEntityData(
        meta: MetaEntity<ID_TYPE>,
        idGenerator: () -> Set<ID_TYPE>,
        init: (ID_TYPE, MetaEntity<ID_TYPE>) -> T,
    ): Set<T>
            where T : EntityTemplate<ID_TYPE> {
        return idGenerator().map { init(it, meta) }.toSet()
    }

    inline fun <reified ID_TYPE, reified T> genOneEntityData(
        meta: MetaEntity<ID_TYPE>,
        idGenerator: () -> ID_TYPE,
        init: (ID_TYPE, MetaEntity<ID_TYPE>) -> T,
    ): T
            where T : EntityTemplate<ID_TYPE> {
        return init(idGenerator(), meta)
    }

    inline fun <reified ID_TYPE, reified T>  genIdForRef(): T{

        TODO()
    }

}