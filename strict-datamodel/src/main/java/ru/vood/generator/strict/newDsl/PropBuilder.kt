package ru.vood.generator.strict.newDsl

import ru.vood.generator.strict.DataType
import ru.vood.generator.strict.EntityTemplate
import ru.vood.generator.strict.dsl.Builder
import ru.vood.generator.strict.dsl.FieldName
import ru.vood.generator.strict.dsl.GenerateFieldValueFunction
import ru.vood.generator.strict.dsl.MetaProperty
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

@Deprecated("asda")
class PropBuilder<ET_ID_TYPE, R>(
    var name: FieldName = "",
    var function: GenerateFieldValueFunction<ET_ID_TYPE, DataType<R>> = { _, _ ->
        error("Необходимо определить ф-цию в мете")
    }
) : Builder<MetaProperty<ET_ID_TYPE, R>>
//where ET: EntityTemplate<Any>
{

    operator fun provideDelegate(
        thisRef: EntityTemplate<ET_ID_TYPE>,
        property: KProperty<*>
    ): ReadOnlyProperty<EntityTemplate<ET_ID_TYPE>, MetaProperty<ET_ID_TYPE, R>> {
        name = property.name
        val build: MetaProperty<ET_ID_TYPE, R> = this@PropBuilder.build()
        thisRef.addProp(build)
        return ReadOnlyProperty { thisRef, property ->
            return@ReadOnlyProperty build
        }

    }


//    operator fun provideDelegate(
//        thisRef: EntityTemplate<ET_ID_TYPE>,
//        property: KProperty<*>
//    ): ReadOnlyProperty<EntityTemplate<ET_ID_TYPE>, PropBuilder<ET_ID_TYPE, R>> {
//        name = property.name
//        val build: MetaProperty<ET_ID_TYPE, R> = this@PropBuilder.build()
//        thisRef.addProp(build)
//        TODO()
////        return ReadOnlyProperty { thisRef, property ->
////            return@ReadOnlyProperty build
////        }
//
//    }

    override fun build(): MetaProperty<ET_ID_TYPE, R> {
        TODO("Not yet implemented")
    }
}

//inner class MetaPropertyBuilder<R>(
//    var name: FieldName = "",
//    var function: GenerateFieldValueFunction<ET_ID, DataType<R>> = { _, _ ->
//        error("Необходимо определить ф-цию в мете")
//    }
//) : Builder<MetaProperty<ET_ID, R>> {
//
//    operator fun provideDelegate(
//        thisRef: Nothing?,
//        property: KProperty<*>
//    ): ReadOnlyProperty<Nothing?, MetaProperty<ET_ID, R>> {
//        name = property.name
//        val mEntBuild: MetaEntBuilder<ET_ID> = this@MetaEntBuilder
//        mEntBuild.propertyBuilder.add(this@MetaPropertyBuilder)
//        return ReadOnlyProperty { thisRef, property ->
//            return@ReadOnlyProperty this@MetaPropertyBuilder.build()
//        }
//    }
//
//    override fun build(): MetaProperty<ET_ID, R> {
//        return MetaProperty(name, function)
//    }
//
//}