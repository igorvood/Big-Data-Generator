package ru.vood.generator.datamodel.dataType.meta.dsl

import ru.vood.generator.datamodel.dataType.meta.type.DataType
import ru.vood.generator.datamodel.dataType.meta.type.EntityTemplate
import java.math.BigDecimal
import java.time.LocalDateTime
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


class MetaEntBuilder<ET : EntityTemplate<ET>> : Builder<MetaEnt<ET>> {
    var name: EntityName = ""
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
    val STRING = string()
    fun number() = MetaPropertyBuilder<BigDecimal>()
    val NUMBER = number()
    fun date() = MetaPropertyBuilder<LocalDateTime>()
    val DATE = date()

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
            mEntBuild.propertyBuilder.add(this@MetaPropertyBuilder)
            return ReadOnlyProperty { thisRef, property ->
                return@ReadOnlyProperty this@MetaPropertyBuilder.build()
            }
        }

        override fun build(): MetaProperty<ET, R> {
            return MetaProperty(name, function)
        }
    }
}

inline infix fun <reified R, reified ET : EntityTemplate<ET>> MetaEntBuilder<ET>.MetaPropertyBuilder<R>.withFun(
    noinline f: GenerateFieldValueFunction<ET, R>
): MetaEntBuilder<ET>.MetaPropertyBuilder<R> {
    this.function = f
    return this
}

inline infix fun <reified R, reified ET : EntityTemplate<ET>> MetaEntBuilder<ET>.MetaPropertyBuilder<R>.with(
    crossinline f: GenerateFieldValueFunctionDsl<ET, R>
): MetaEntBuilder<ET>.MetaPropertyBuilder<R> {
    this.function =
        { entityTemplate, parameterName ->
            object : DataType<R> {
                override fun value(): R {
                    return f(entityTemplate, parameterName)
                }
            }
        }
    return this
}

inline fun <reified T : EntityTemplate<T>> entity(crossinline body: MetaEntBuilder<T>.() -> Unit): ReadOnlyProperty<Nothing?, MetaEnt<T>> {

    return ReadOnlyProperty { thisRef, property ->
        val metaEntBuilder = MetaEntBuilder<T>()
        metaEntBuilder.name = property.name
        metaEntBuilder.body()
        metaEntBuilder.build()
    }

}