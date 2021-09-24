package ru.vood.generator.datamodel.dataType.meta.lk

import ru.vood.generator.datamodel.dataType.meta.score.ScoreDto
import ru.vood.generator.datamodel.dataType.meta.type.DataType
import ru.vood.generator.datamodel.dataType.meta.type.EntityTemplate

typealias LkPk = Pair<String, ScoreDto>
typealias DataTypeLkPkId = DataType<Pair<String, ScoreDto>>

fun convId(id: LkPk): DataType<Pair<String, ScoreDto>> {
    return object : DataType<Pair<String, ScoreDto>> {
        override fun value(): Pair<String, ScoreDto> {
            return id
        }
    }
}

class LkFunctionalDto(
    id: LkPk,
) : EntityTemplate<DataTypeLkPkId>(convId(id))


