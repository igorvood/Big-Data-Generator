package ru.vood.generator.datamodel.dataType.meta.dsl.n

import ru.vood.generator.datamodel.dataType.meta.*
import ru.vood.generator.datamodel.dataType.meta.type.DataType
import ru.vood.generator.datamodel.dataType.meta.type.EntityTemplate
import ru.vood.generator.datamodel.dataType.meta.type.StringType
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class MetaEntityBuilder<ET : EntityTemplate<ET>> : Builder<MetaEnt<ET>> {
    var name: EntityName = ""
    val property: MutableSet<MetaProperty<ET, *>> = mutableSetOf()
    val ck: MutableSet<MetaCk<ET>> = mutableSetOf()
    val fk: MutableSet<MetaFk<ET>> = mutableSetOf()

    override fun build(): MetaEnt<ET> {
        return MetaEnt(name, property, ck, fk)
    }

    inner class MPropBuild<R>(
        var name: FieldName = "",
        var function: GenerateFieldValueFunction<ET, R> = { _, _ ->
            object : DataType<R> {
                override fun value(): R {
                    error("Not defined")
                }
            }
        }
    ) : Builder<MetaProperty<ET, R>> {
        override fun build(): MetaProperty<ET, R> {
            return MetaProperty(name, function)
        }

        operator fun provideDelegate(
            thisRef: Nothing?,
            property: KProperty<*>
        ): ReadOnlyProperty<Nothing?, MetaProperty<ET, R>> {
            name = property.name
            val build: MetaProperty<ET, R> = this@MPropBuild.build()
            val mEntBuild: MetaEntityBuilder<ET> = this@MetaEntityBuilder
            mEntBuild.property.add(build)
            return ReadOnlyProperty { thisRef, property ->
                return@ReadOnlyProperty build
            }
        }

        fun string(): ReadOnlyProperty<Nothing?, MPropBuild<StringType>> {
            return ReadOnlyProperty { thisRef, property ->
                val metaPropertyBuilder = MPropBuild<StringType>()
                metaPropertyBuilder.name = property.name
                return@ReadOnlyProperty metaPropertyBuilder
            }
        }
    }
}
