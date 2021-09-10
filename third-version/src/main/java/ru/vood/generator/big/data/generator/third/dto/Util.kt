package ru.vood.generator.big.data.generator.third.dto

fun <T> oneOf(t0: T, t1: T, vararg tn: T): T {
    return t0
}

fun <T> oneOf(vals: List<T>): T {
    return vals[(vals.indices).random()]
}
