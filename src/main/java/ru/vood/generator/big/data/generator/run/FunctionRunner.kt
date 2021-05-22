package ru.vood.generator.big.data.generator.run

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service
import ru.vood.generator.big.data.generator.data.gen.NewFilePutter
import ru.vood.generator.big.data.generator.data.gen.score.AbstractGenerateCollection
import ru.vood.generator.big.data.generator.data.gen.score.Score
import ru.vood.generator.big.data.generator.data.gen.score.ScoreMapGenerator
import ru.vood.generator.big.data.generator.file.FilePutter

@Service
class FunctionRunner(
        private val generateCollection: AbstractGenerateCollection,
        private val filePutter: NewFilePutter
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val scoreList = generateCollection.genList(100_000, 200_000) {cnt->
            Score(cnt.toString(),{ "${it}_crm" },{ "${it}_inn" }
            )
        }

        filePutter.toFile(scoreList, ScoreMapGenerator())

        println(scoreList)

    }
}