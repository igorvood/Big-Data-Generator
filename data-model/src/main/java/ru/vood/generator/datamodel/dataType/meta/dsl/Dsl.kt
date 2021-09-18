package ru.vood.generator.datamodel.dataType.meta.dsl

import ru.vood.generator.datamodel.dataType.meta.*
import ru.vood.generator.datamodel.dataType.meta.dsl.n.Builder
import ru.vood.generator.datamodel.dataType.meta.type.DataType
import ru.vood.generator.datamodel.dataType.meta.type.EntityTemplate
import java.math.BigDecimal
import java.time.LocalDateTime
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


class MetaEntBuilder<ET : EntityTemplate<ET>> : Builder<MetaEnt<ET>> {
    var name: EntityName = ""

    //    val property: MutableSet<MetaProperty<ET, *>> = mutableSetOf()
    val propertyBuilder: MutableSet<MetaPropertyBuilder<*>> = mutableSetOf()
    val ck: MutableSet<MetaCk<ET>> = mutableSetOf()
    val fk: MutableSet<MetaFk<ET>> = mutableSetOf()

    override fun build(): MetaEnt<ET> {
        return MetaEnt(
            name = name,
            property = propertyBuilder.map { it.build() }.toSet(),
            ck = ck,
            fk = fk
        )
    }


    fun string() = MetaPropertyBuilder<String>()
    fun number() = MetaPropertyBuilder<BigDecimal>()
    fun date() = MetaPropertyBuilder<LocalDateTime>()

    inline fun <reified Z> ref() = MetaPropertyBuilder<Z>()

    inline fun <reified Z> set() = MetaPropertyBuilder<Set<Z>>()

    inner class MetaPropertyBuilder<R>(
        var name: FieldName = "",
        var function: GenerateFieldValueFunction<ET, R> = { _, _ ->
            object : DataType<R> {
                override fun value(): R {
                    error("Not defined")
                }
            }
        }
    ) : Builder<MetaProperty<ET, R>> {
        operator fun provideDelegate(
            thisRef: Nothing?,
            property: KProperty<*>
        ): ReadOnlyProperty<Nothing?, MetaProperty<ET, R>> {
            name = property.name
            val mEntBuild: MetaEntBuilder<ET> = this@MetaEntBuilder
/*
            val build: MetaProperty<ET, R> = this@MetaPropertyBuilder.build()
            mEntBuild.property.add(build)
*/
            mEntBuild.propertyBuilder.add(this@MetaPropertyBuilder)
            return ReadOnlyProperty { thisRef, property ->
                return@ReadOnlyProperty this@MetaPropertyBuilder.build()
            }
        }

        override fun build(): MetaProperty<ET, R> {
            return MetaProperty(name, function)
        }
        /*fun string(): ReadOnlyProperty<Nothing?, MetaPropertyBuilder<StringType>> {
            return ReadOnlyProperty { thisRef, property ->
                val metaPropertyBuilder = MetaPropertyBuilder<StringType>()
                metaPropertyBuilder.name = property.name
                return@ReadOnlyProperty metaPropertyBuilder
            }
        }*/
    }
}

infix fun <R, ET : EntityTemplate<ET>> MetaEntBuilder<ET>.MetaPropertyBuilder<R>.withFun(
    f: GenerateFieldValueFunction<ET, R>
): MetaEntBuilder<ET>.MetaPropertyBuilder<R> {
    this.function = f
    return this
}

infix fun <R, ET : EntityTemplate<ET>> MetaEntBuilder<ET>.MetaPropertyBuilder<R>.withFun2(
    f: GenerateFieldValueFunctionDsl<ET, R>
): MetaEntBuilder<ET>.MetaPropertyBuilder<R> {
    this.function = convert(f)
    return this
}

fun <T:EntityTemplate<T>, OUT_TYPE> convert2(f: (T, ) -> OUT_TYPE): GenerateFieldValueFunction<T, OUT_TYPE> {
    TODO()
}

fun <T:EntityTemplate<T>, OUT_TYPE> convert(f: GenerateFieldValueFunctionDsl<T, OUT_TYPE>): GenerateFieldValueFunction<T, OUT_TYPE> {
    return object : GenerateFieldValueFunction<T, OUT_TYPE> {
        override fun invoke(p1: EntityTemplate<T>, p2: String): DataType<OUT_TYPE> {
            return object : DataType<OUT_TYPE> {
                override fun value(): OUT_TYPE {
                    return f(p1, p2)()
                }
            }
        }
    }
}

fun <T : EntityTemplate<T>> entity(body: MetaEntBuilder<T>.() -> Unit): ReadOnlyProperty<Nothing?, MetaEnt<T>> {

    return ReadOnlyProperty { thisRef, property ->
        val metaEntBuilder = MetaEntBuilder<T>()
        metaEntBuilder.name = property.name
        metaEntBuilder.body()
        metaEntBuilder.build()
    }

}