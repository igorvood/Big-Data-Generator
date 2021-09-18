package ru.vood.generator.datamodel.dataType.meta.type

import java.math.BigDecimal

data class NumberType(val value: BigDecimal) : DataType<BigDecimal> {
    override fun value(): BigDecimal = value
}