package ru.vood.generator.datamodel.templatedto.meta.client

import ru.vood.generator.datamodel.templatedto.dsl.MetaEntity
import ru.vood.generator.datamodel.templatedto.EntityTemplate

abstract class Client(
    id: String,
    meta: MetaEntity<String>
) : EntityTemplate<String>(id, meta)