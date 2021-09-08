package ru.vood.generator.forth.rest

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import ru.vood.generator.datamodel.score.ScoreFunctionalDto


@RestController
class ScoreRestController : EntityRestControllerService<ScoreFunctionalDto> {

    @GetMapping(value = ["/score/{entityId}"])
    override fun readEntity(@PathVariable entityId: String): ScoreFunctionalDto {
        return ScoreFunctionalDto(entityId)
    }

    @GetMapping(value = ["/hello"])
    fun asd(): ScoreFunctionalDto {
        return ScoreFunctionalDto("entityId")
    }
}