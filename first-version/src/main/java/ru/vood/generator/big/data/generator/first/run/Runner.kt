package ru.vood.generator.big.data.generator.first.run

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service
import ru.vood.generator.big.data.generator.first.collection.GenerateCollection
import ru.vood.generator.big.data.generator.first.dto.Score
import ru.vood.generator.big.data.generator.first.file.FilePutter
import ru.vood.generator.big.data.generator.first.gen.GeneratorData

@Service
class Runner(
    private val scoreGen: GeneratorData<Score>,
    private val generateCollection: GenerateCollection,
    val filePutter: FilePutter

) : CommandLineRunner {
    val logger = LoggerFactory.getLogger(Runner::class.java)

    override fun run(vararg args: String) {
        logger.info("Run")
        val genSet = generateCollection.genSet(299, 300, scoreGen)
        logger.info("End generating")
        filePutter.toFile(genSet.toList())
        logger.info("End writing Score")
        val cluList = genSet.flatMap { it.clus }.toSet().toList()
        filePutter.toFile(cluList)
        logger.info("End writing Clu")

    }
}