package ru.vood.generator.datamodel.dataType.meta.score

import ru.vood.generator.datamodel.dataType.meta.GenerateFieldValueFunction
import ru.vood.generator.datamodel.dataType.meta.MetaEnt
import ru.vood.generator.datamodel.dataType.meta.MetaProperty
import ru.vood.generator.datamodel.dataType.meta.dsl.entity
import ru.vood.generator.datamodel.dataType.meta.type.DataType
import ru.vood.generator.datamodel.dataType.meta.type.EntityTemplate
import ru.vood.generator.datamodel.dataType.meta.type.StringType
import kotlin.properties.ReadOnlyProperty

class ScoreDto(id: String) : EntityTemplate<String>(id)


fun asd() {


    val value = object :
        GenerateFieldValueFunction<ScoreDto> {
        override fun invoke(entityTemplate: EntityTemplate<ScoreDto>, s: String): DataType<*> {
            return StringType { "${entityTemplate.id}_$s" }
        }
    }

    val asdf: GenerateFieldValueFunction<ScoreDto> =
        value

    val ent = MetaEnt<ScoreDto>(
        name = "score",
        property = setOf(
            MetaProperty(
                "riskSegmentOffline",
                object : GenerateFieldValueFunction<ScoreDto> {
                    override fun invoke(entityTemplate: EntityTemplate<ScoreDto>, s: String): DataType<*> {
                        return StringType { "${entityTemplate.id}_$s" }
                    }
                }
            )
        ),
    )

}