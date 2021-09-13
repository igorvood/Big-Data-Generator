package ru.vood.generator.datamodel.dataType.meta.dsl

import ru.vood.generator.datamodel.dataType.meta.*
import ru.vood.generator.datamodel.dataType.meta.dsl.MetaEntBuilder.*
import ru.vood.generator.datamodel.dataType.meta.type.DataType
import ru.vood.generator.datamodel.dataType.meta.type.StringType
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


class MetaEntBuilder<T> internal constructor() {
    var name: EntityName = ""
    internal val property: MutableSet<MetaProperty<T>> = mutableSetOf()
    internal val ck: MutableSet<MetaCk<T>> = mutableSetOf()
    internal val fk: MutableSet<MetaFk<T>> = mutableSetOf()

    fun build(): MetaEnt<T> {
        return MetaEnt(name, property, ck, fk)
    }


    //    val string get() = MetaPropertyBuilder()
    inner class MetaPropertyBuilder<T>(
        var name: FieldName = "",
        var function: GenerateFieldValueFunction<T> = { _, _ ->
            object : DataType<T> {
                override fun value(): T {
                    error("Not defined")
                }
            }
        }
    ) {
        operator fun provideDelegate(
            thisRef: Nothing?,
            property: KProperty<*>
        ): ReadOnlyProperty<Nothing?, MetaProperty<T>> {
//            name = property.name
//            val e: MetaProperty<T> = this@MetaPropertyBuilder.build()
//            val metaEntBuilder: MetaEntBuilder<Any> = this@MetaEntBuilder
//            metaEntBuilder.property.add(element = MetaProperty("sadasd" ))
            TODO()
            /*return ReadOnlyProperty { thisRef, property ->
                val metaPropertyBuilder = MetaPropertyBuilder<T>()
                metaPropertyBuilder.name = property.name
                return@ReadOnlyProperty metaPropertyBuilder
            }*/
        }

        /*
        * Type mismatch.Required:MetaProperty<T#1 (type parameter of ru.vood.generator.datamodel.dataType.meta.dsl.MetaEntBuilder)>
Found:                           MetaProperty<T#2 (type parameter of ru.vood.generator.datamodel.dataType.meta.dsl.MetaEntBuilder.MetaPropertyBuilder)>
        * */

        fun build(): MetaProperty<T> {
            return MetaProperty<T>(name, function)
        }
    }

    fun string(): ReadOnlyProperty<Nothing?, MetaPropertyBuilder<StringType>> {
        return ReadOnlyProperty { thisRef, property ->
            val metaPropertyBuilder = MetaPropertyBuilder<StringType>()
            metaPropertyBuilder.name = property.name
            return@ReadOnlyProperty metaPropertyBuilder
        }
    }

//    public infix fun <T> MetaPropertyBuilder<T>.withFun(f: GenerateFieldValueFunction<T>): MetaPropertyBuilder<T> {
//        this.function = f
//        return this
//    }


}




fun <T> entity(body: MetaEntBuilder<T>.() -> Unit): ReadOnlyProperty<Nothing?, MetaEnt<T>> {

    return ReadOnlyProperty { thisRef, property ->
        val metaEntBuilder = MetaEntBuilder<T>()
        metaEntBuilder.name = property.name
        metaEntBuilder.body()
        metaEntBuilder.build()
    }

}
