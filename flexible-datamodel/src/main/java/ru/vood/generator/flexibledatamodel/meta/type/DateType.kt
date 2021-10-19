package ru.vood.generator.flexibledatamodel.meta.type

import ru.vood.generator.flexibledatamodel.dsl.DataType
import java.time.LocalDateTime

data class DateType(val value: LocalDateTime) : DataType<LocalDateTime> {
    override fun value(): LocalDateTime = value
}