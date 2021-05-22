package ru.vood.generator.big.data.generator.run

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service
import ru.vood.generator.big.data.generator.collection.GenerateCollection
import ru.vood.generator.big.data.generator.data.Score
import ru.vood.generator.big.data.generator.simpleGen.GeneratorData

@Service
class Runner(
        private val scoreGen: GeneratorData<Score>,
        private val generateCollection: GenerateCollection

) : CommandLineRunner {
    val logger = LoggerFactory.getLogger(Runner::class.java)

    override fun run(vararg args: String) {
        logger.info("Run")
        val genSet = generateCollection.genSet(2000, 3000, scoreGen)
        logger.info("End")

    }
}