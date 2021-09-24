package ru.vood.generator.datamodel.dataType.meta.score

import ru.vood.generator.datamodel.dataType.meta.dsl.MetaEntity
import ru.vood.generator.datamodel.dataType.meta.type.EntityTemplate

class ScoreDto(id: String, meta: MetaEntity<String>) :
    EntityTemplate<String>(id, meta)


inline fun <reified ID_TYPE, reified T> genFixed(
    meta: MetaEntity<ID_TYPE>,
    idGenerator: () -> Set<ID_TYPE>,
    init: (ID_TYPE, MetaEntity<ID_TYPE>) -> T,
): Set<T>
        where T : EntityTemplate<ID_TYPE> {
    return idGenerator().map { init(it, meta) }.toSet()
}



