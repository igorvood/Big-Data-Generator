package ru.vood.generator.datamodel.dataType.meta.score

import ru.vood.generator.datamodel.dataType.meta.dsl.MetaEntity
import ru.vood.generator.datamodel.dataType.meta.type.DataType
import ru.vood.generator.datamodel.dataType.meta.type.EntityTemplate
import ru.vood.generator.datamodel.dataType.meta.type.StringTypeNotNull

class ScoreDto(id: String, meta: MetaEntity<EntityTemplate<StringTypeNotNull>, StringTypeNotNull>) :
    EntityTemplate<StringTypeNotNull>(StringTypeNotNull(id), meta)


class GenScore(val id: String, val meta: MetaEntity<EntityTemplate<StringTypeNotNull>, StringTypeNotNull>) {

    fun sdfasdf() {
        val scoreDto = ScoreDto(id, meta)
    }

}

private fun <R_ID_TYPE> getDT(v:R_ID_TYPE):DataType<R_ID_TYPE>{
   return object : DataType<R_ID_TYPE> {
        override fun value(): R_ID_TYPE = v
    }
}

fun <R_ID_TYPE, ID_TYPE : DataType<R_ID_TYPE>> gen(
    id: R_ID_TYPE,
    meta: MetaEntity<EntityTemplate<ID_TYPE>, ID_TYPE>
): EntityTemplate<ID_TYPE> {
    return object : EntityTemplate<ID_TYPE>(getDT(id) as ID_TYPE, meta) {}
}

