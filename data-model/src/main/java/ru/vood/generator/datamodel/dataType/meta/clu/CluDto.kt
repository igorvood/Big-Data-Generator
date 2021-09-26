package ru.vood.generator.datamodel.dataType.meta.clu

import ru.vood.generator.datamodel.dataType.meta.dsl.MetaEntity
import ru.vood.generator.datamodel.dataType.meta.score.ScoreDto
import ru.vood.generator.datamodel.dataType.meta.type.EntityTemplate

typealias CluPk = Pair<String, EntityTemplate<String>>

class CluDto(id: String, meta: MetaEntity<String>) :
    EntityTemplate<String>(id, meta)






