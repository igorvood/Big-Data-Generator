package ru.vood.generator.datamodel.util

import kotlin.reflect.KCallable

interface MetaDataInterface {

    fun metaFields(): Set<KCallable<*>>

    fun fieldsMetaMap(): Map<String, FieldMeta>
}
