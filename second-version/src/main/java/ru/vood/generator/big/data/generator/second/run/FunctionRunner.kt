package ru.vood.generator.big.data.generator.second.run

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Service
import ru.vood.generator.big.data.generator.second.dto.score.Score
import ru.vood.generator.big.data.generator.second.dto.score.ScoreMapGenerator
import ru.vood.generator.big.data.generator.second.gen.AbstractGenerateCollection
import ru.vood.generator.big.data.generator.second.gen.NewFilePutter

@Service
class FunctionRunner(
    private val generateCollection: AbstractGenerateCollection,
    private val filePutter: NewFilePutter
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        val scoreList = generateCollection.genList(11_000_000, 12_200_000) { cnt ->
            Score(cnt.toString(), { "crm_${it.hashCode()}" }, { "inn_${it.hashCode()}" }
            )
        }
        filePutter.toFile(scoreList, ScoreMapGenerator())

    }
}