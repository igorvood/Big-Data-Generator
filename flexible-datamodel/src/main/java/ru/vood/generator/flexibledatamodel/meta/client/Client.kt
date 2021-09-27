package ru.vood.generator.flexibledatamodel.meta.client

import ru.vood.generator.flexibledatamodel.EntityTemplate
import ru.vood.generator.flexibledatamodel.dsl.MetaEntity

abstract class Client(
    id: String,
    meta: MetaEntity<String>
) : EntityTemplate<String>(id, meta)