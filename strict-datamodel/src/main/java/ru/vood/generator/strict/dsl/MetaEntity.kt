package ru.vood.generator.strict.dsl

import ru.vood.generator.strict.DataType
import ru.vood.generator.strict.EntityTemplate
import java.util.Comparator

data class MetaEntity<ID_TYPE>
//        where T: EntityTemplate<Q>
    (
    val name: EntityName,
    val property: Set<MetaProperty<ID_TYPE, *>>,
    val ck: Set<MetaCheck<EntityTemplate<ID_TYPE>>> = setOf(),
    val fk: Set<MetaFk<EntityTemplate<ID_TYPE>>> = setOf(),
)

data class MetaProperty<ID_TYPE, OUT_TYPE>(
    val name: FieldName,
    val function: GenerateFieldValueFunction<ID_TYPE, DataType<OUT_TYPE>>
) : (EntityTemplate<ID_TYPE>) -> OUT_TYPE
,Comparator<MetaProperty<ID_TYPE, OUT_TYPE>>
{
    override fun invoke(p1: EntityTemplate<ID_TYPE>): OUT_TYPE = function(p1, name)()
    override fun compare(o1: MetaProperty<ID_TYPE, OUT_TYPE>?, o2: MetaProperty<ID_TYPE, OUT_TYPE>?): Int {
        return o1!!.name.compareTo(o2!!.name)
    }
}

data class MetaCheck<T>(
    val name: ConstraintName,
    val checkFunction: (T) -> Boolean
)

data class MetaFk<T>(
    val name: ConstraintName
)
