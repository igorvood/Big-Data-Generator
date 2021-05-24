package ru.vood.generator.big.data.generator.third.run

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service
import ru.vood.generator.big.data.generator.third.dto.*

@Service
class ThirdRunner: CommandLineRunner {

    val vals = Types.values().toList()

    override fun run(vararg args: String?) {
        val cols = IntRange(1, 20)
                .map {
                    ColumnDto("Col_$it",  oneOf(vals))
                }
                .plus(ColumnDto("id", Types.CHAR, isAf = false, isId = true)).toSet()
        val entityDto = EntityDto("score", cols)
        val entityGenerate = EntityGenerate(1, entityDto)

        val map = entityGenerate.valueFunction()
                .map { it.key to it.value.apply(1) }
                .toMap()

        println(map)


    }
}