package ru.vood.generator.strict.meta

import ru.vood.generator.strict.EntityTemplate
import java.time.LocalDateTime


class ScoreDto(
    id: String,
//    val f1 by string()// genVal stdStr(),
) : EntityTemplate<String>(id) {
    val s1 by string() genVal { q, w -> id } //getFun()// stdStr()
    val s2 by string() genVal { q, w -> id } //getFun()// stdStr()

    val n1 by number() genVal { q, w -> id.hashCode().toBigDecimal() } //getFun()// stdStr()
    val n2 by number() genVal { q, w -> id.hashCode().toBigDecimal() } //getFun()// stdStr()

    val b1 by bool() genVal { q, w -> true } //getFun()// stdStr()
    val b2 by bool() genVal { q, w -> true } //getFun()// stdStr()

    val d1 by date() genVal { q, w -> LocalDateTime.MIN } //getFun()// stdStr()
    val d2 by date() genVal { q, w -> LocalDateTime.MIN } //getFun()// stdStr()
}

