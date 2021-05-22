package ru.vood.generator.big.data.generator.run

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service
import ru.vood.generator.big.data.generator.data.gen.score.AbstractGenerateCollection
import ru.vood.generator.big.data.generator.data.gen.score.Score

@Service
class FunctionRunner(private val generateCollection: AbstractGenerateCollection) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val genList = generateCollection.genList(10_000_000, 20_000_000) { Score(it.toString())
        }

        println(genList)

    }
}