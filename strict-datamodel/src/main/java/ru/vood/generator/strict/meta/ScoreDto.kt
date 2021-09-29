package ru.vood.generator.strict.meta

import ru.vood.generator.strict.EntityTemplate

class ScoreDto(
    id: String,
//    val f1 by string()// genVal stdStr(),
): EntityTemplate<String>(id){
    val f1 by string() genVal {q,w-> id} //getFun()// stdStr()
}

