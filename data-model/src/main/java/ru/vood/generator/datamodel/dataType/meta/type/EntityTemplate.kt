package ru.vood.generator.datamodel.dataType.meta.type

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import ru.vood.generator.datamodel.dataType.meta.dsl.MetaEntity
import java.math.BigDecimal
import java.time.LocalDateTime

abstract class EntityTemplate<ID_TYPE>(
    id: ID_TYPE,
    val meta: MetaEntity<ID_TYPE>
) : DataType<EntityTemplate<ID_TYPE>> {

    val id: DataType<ID_TYPE> = object : DataType<ID_TYPE> {
        override fun value(): ID_TYPE {
            return id
        }
    }

    override fun value(): EntityTemplate<ID_TYPE> = this

    fun getJson(): JsonObject {
        val jsonObject = JsonObject()
        this.meta.property.forEach { prop ->
            val value = prop.function(this, prop.name)
            val trueVal = value.value()
            when (trueVal) {
                is EntityTemplate<*> -> jsonObject.add(prop.name, trueVal.getJson())
                is Set<*> -> {
                    val jsonArray = JsonArray()
                    trueVal.forEach { ent ->
                        val entityTemplate = ent as EntityTemplate<*>
                        jsonArray.add(entityTemplate.getJson())
                    }
                    jsonObject.add(prop.name, jsonArray)
                }
                is BigDecimal -> jsonObject.addProperty(prop.name, trueVal)
                is String -> jsonObject.addProperty(prop.name, trueVal)
                is LocalDateTime -> jsonObject.addProperty(prop.name, trueVal.toString())
                is Boolean -> jsonObject.addProperty(prop.name, trueVal)
                else -> error("для свойства ${prop.name} нет подержки типа ${value.javaClass} ")
            }
        }
        return jsonObject
    }

}