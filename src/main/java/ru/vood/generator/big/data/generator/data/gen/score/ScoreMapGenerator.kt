package ru.vood.generator.big.data.generator.data.gen.score

import ru.vood.generator.big.data.generator.data.gen.MapGenerator

class ScoreMapGenerator : MapGenerator<Score> {

    override fun keyValMapper(key: String, data: Score): Any {
        return when (key) {
            ScoreMeta.ID.s -> data.id
            ScoreMeta.CRM_ID.s -> data.crmId()
            ScoreMeta.INN.s -> data.inn()
            else -> error("ScoreMapGenerator $key unsupported")
        }
    }
}