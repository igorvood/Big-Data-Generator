package ru.vood.generator.datamodel.dataType.meta.client

import ru.vood.generator.datamodel.dataType.meta.dsl.MetaEntity
import ru.vood.generator.datamodel.dataType.meta.type.EntityTemplate

abstract class Client(
    id: String,
    meta: MetaEntity<String>
) : EntityTemplate<String>(id, meta)