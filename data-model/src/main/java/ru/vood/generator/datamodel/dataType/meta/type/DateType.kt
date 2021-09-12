package ru.vood.generator.datamodel.dataType.meta.type

import java.time.LocalDateTime

data class DateType(val value: () -> LocalDateTime) : DataType<LocalDateTime> {
    override fun value(): LocalDateTime = value()
}