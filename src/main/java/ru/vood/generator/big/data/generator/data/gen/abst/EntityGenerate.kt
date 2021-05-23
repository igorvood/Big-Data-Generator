package ru.vood.generator.big.data.generator.data.gen.abst

import ru.vood.generator.big.data.generator.data.gen.MetaDataInterface
import ru.vood.generator.big.data.generator.data.gen.abst.dto.EntityDto
import java.time.LocalTime
import java.time.temporal.ChronoUnit
import java.util.function.BiFunction
import java.util.function.Function

class EntityGenerate(
        val id: Int,
        val ent: EntityDto,
        val overrideFun: Map<String, Function<Int, String>> = mapOf()
) : MetaDataInterface {

    override fun headers(): Set<String> {
        return ent.columns.map { it.name }.toSet()
    }

    var biFunctionAny: BiFunction<Int, String, String> = BiFunction { integer, s -> "${s}_${integer.hashCode()}" }

    var biFunctionId: BiFunction<Int, String, String> = BiFunction { integer, _ -> "$integer" }

    fun valueFunction(): Map<String, Function<Int, String>> {
        val map = ent.columns
                .map { col ->
                    val s: Function<Int, String> = when (col.type) {
                        Types.CHAR -> {
                            if (!col.isId)
                                Function { integer -> "${col.name}_${integer.hashCode()}" }
                            else Function { id.toString() }
                        }
                        Types.NUM -> Function { integer -> integer.hashCode().toString() }
                        Types.DATE -> Function { integer ->
                            val plus = LocalTime.now().plus(integer.hashCode().toLong(), ChronoUnit.HALF_DAYS)
                            plus.toString()
                        }
                        else -> error("Unsupported type ${col.type}")
                    }
                    col.name to (overrideFun[col.name] ?: s)
                }.toMap()
        return map
    }

    fun value(): Map<String, String> {
        val funs = valueFunction()
        val toMap = headers()
                .map { colName -> colName to (funs[colName] ?: error("no fun for col $colName")).apply(id) }
                .toMap()
        return toMap
    }

    fun headerStr():String{
        return headers().joinToString(";")
    }

    fun dataStr():String{
        val value = value()
        return headers().map {colName ->  value[colName] }.joinToString(";")
    }

}