package ru.vood.generator.big.data.generator.run

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import ru.vood.generator.big.data.generator.collection.GenerateCollection
import ru.vood.generator.big.data.generator.data.Score
import ru.vood.generator.big.data.generator.file.FilePutter
import ru.vood.generator.big.data.generator.simpleGen.GeneratorData

//@Service
class Runner(
        private val scoreGen: GeneratorData<Score>,
        private val generateCollection: GenerateCollection,
        val filePutter: FilePutter

) : CommandLineRunner {
    val logger = LoggerFactory.getLogger(Runner::class.java)

    override fun run(vararg args: String) {
        logger.info("Run")
        val genSet = generateCollection.genSet(299_000, 300_000, scoreGen)
        logger.info("End generating")
        filePutter.toFile(genSet.toList())
        logger.info("End writing Score")
        val cluList = genSet.flatMap { it.clus }.toSet().toList()
        filePutter.toFile(cluList)
        logger.info("End writing Clu")

    }
}