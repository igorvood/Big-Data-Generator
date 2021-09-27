package ru.vood.generator.flexibledatamodel.meta.type

import ru.vood.generator.flexibledatamodel.DataType
import java.math.BigDecimal

data class NumberType(val value: BigDecimal) : DataType<BigDecimal> {
    override fun value(): BigDecimal = value
}