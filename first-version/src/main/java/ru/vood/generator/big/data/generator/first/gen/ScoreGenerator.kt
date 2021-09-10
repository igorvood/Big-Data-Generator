package ru.vood.generator.big.data.generator.first.gen

import org.springframework.stereotype.Service
import ru.vood.generator.big.data.generator.first.collection.GenerateCollection
import ru.vood.generator.big.data.generator.first.dto.Clu
import ru.vood.generator.big.data.generator.first.dto.Score

@Service
class ScoreGenerator(
    private val strGen: GeneratorData<String>,
    private val cluGen: GeneratorData<Clu>,
    private val generateCollection: GenerateCollection
) : GeneratorData<Score> {


    override fun gen(): Score {
        val cluSet = generateCollection.genSet(1, 10_000, cluGen)
        val score = Score(strGen.gen(), strGen.gen(), strGen.gen(), cluSet)
        return score
    }
}