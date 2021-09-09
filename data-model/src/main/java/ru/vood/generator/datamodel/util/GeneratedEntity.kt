package ru.vood.generator.datamodel.util

import ru.vood.generator.datamodel.valueCalculate
import java.time.LocalDateTime
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

interface GeneratedEntity<T : MetaDataInterface> : MetaDataInterface {

    fun objectInMap(): Map<String, Any>

    fun <IN, R> valueAny(id: IN, block: (IN) -> R): ReadOnlyProperty<T, R> = ReadOnlyProperty { _, _ -> block(id) }

    fun <IN> valueStr(id: IN, block: ((IN) -> String)? = null) =
        ReadOnlyProperty<T, String> { _, property ->
            blockRunner(id, block) { it.toString() + property.name }
        }

    fun <IN> valueNum(id: IN, block: ((IN) -> Int)? = null) =
        ReadOnlyProperty<T, Int> { _, property ->
            blockRunner(id, block) { (it.toString() + property.name).hashCode() }
        }

    fun <IN> valueBool(id: IN, block: ((IN) -> Boolean)? = null) =
        ReadOnlyProperty<T, Boolean> { _, property ->
            blockRunner(id, block) { (it.toString() + property.name).hashCode() % 2 == 1 }
        }

    fun <IN> valueTime(id: IN, block: ((IN) -> LocalDateTime)? = null) =
        ReadOnlyProperty<T, LocalDateTime> { _, property ->
            blockRunner(id, block) {
                LocalDateTime.MIN.plusDays(
                    it.hashCode().toLong() + property.name.hashCode().toLong()
                )
            }
        }

    fun <IN> valueConst(value: IN) = ReadOnlyProperty<T, IN> { _, _ ->
        value
    }

    fun objToMap(): ReadOnlyPropertyMap<T> =
        object : ReadOnlyPropertyMap<T> {
            override fun getValue(thisRef: T, property: KProperty<*>): Map<String, Any> {
                return valueCalculate(thisRef.metaFields(), property, thisRef)
            }
        }

    private fun <IN, OUT> blockRunner(id: IN, block: ((IN) -> OUT)?, b: (IN) -> OUT) =
        if (block != null) block(id)
        else b(id)


}
