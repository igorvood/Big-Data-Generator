package ru.vood.generator.datamodel.dataType.meta.clu

import ru.vood.generator.datamodel.dataType.meta.dsl.MetaEntity
import ru.vood.generator.datamodel.dataType.meta.score.ScoreDto
import ru.vood.generator.datamodel.dataType.meta.type.EntityTemplate

typealias CluPk = Pair<String, EntityTemplate<String>>

class CluDto(id: CluPk, meta: MetaEntity<CluPk>) :
    EntityTemplate<CluPk>(id, meta)






