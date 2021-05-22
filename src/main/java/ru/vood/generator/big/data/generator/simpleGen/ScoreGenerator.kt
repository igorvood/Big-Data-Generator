package ru.vood.generator.big.data.generator.simpleGen

import org.springframework.stereotype.Service
import ru.vood.generator.big.data.generator.collection.GenerateCollection
import ru.vood.generator.big.data.generator.data.Clu
import ru.vood.generator.big.data.generator.data.Score

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