package ru.vood.generator.datamodel.dataType.meta.type

import ru.vood.generator.datamodel.templatedto.DataType
import java.time.LocalDateTime

data class DateType(val value: LocalDateTime) : DataType<LocalDateTime> {
    override fun value(): LocalDateTime = value
}