package ru.vood.generator.big.data.generator.run

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service
import ru.vood.generator.big.data.generator.data.gen.NewFilePutter
import ru.vood.generator.big.data.generator.data.gen.AbstractGenerateCollection
import ru.vood.generator.big.data.generator.data.gen.score.Score
import ru.vood.generator.big.data.generator.data.gen.score.ScoreMapGenerator

@Service
class FunctionRunner(
        private val generateCollection: AbstractGenerateCollection,
        private val filePutter: NewFilePutter
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val scoreList = generateCollection.genList(11_000_000, 12_200_000) {cnt->
            Score(cnt.toString(),{ "crm_${it.hashCode()}" },{ "inn_${it.hashCode()}" }
            )
        }
        filePutter.toFile(scoreList, ScoreMapGenerator())
        println(scoreList[1])
    }
}