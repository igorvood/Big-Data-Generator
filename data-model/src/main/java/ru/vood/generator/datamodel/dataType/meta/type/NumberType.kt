package ru.vood.generator.datamodel.dataType.meta.type

import ru.vood.generator.datamodel.templatedto.DataType
import java.math.BigDecimal

data class NumberType(val value: BigDecimal) : DataType<BigDecimal> {
    override fun value(): BigDecimal = value
}