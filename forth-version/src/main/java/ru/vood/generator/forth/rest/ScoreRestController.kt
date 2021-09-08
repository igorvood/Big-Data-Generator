package ru.vood.generator.forth.rest

import org.apache.commons.logging.LogFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import ru.vood.generator.datamodel.score.ScoreFunctionalDto


@RestController
class ScoreRestController : EntityRestControllerService<ScoreFunctionalDto> {

    private val log = LogFactory.getLog(ScoreRestController::class.java)

    @GetMapping(value = ["/score/{entityId}"])
    override fun readEntity(@PathVariable entityId: String): ScoreFunctionalDto {
        log.info("entityId => $entityId")
        val scoreFunctionalDto = ScoreFunctionalDto(entityId)
        val map = scoreFunctionalDto.map
        return scoreFunctionalDto
    }

    @GetMapping(value = ["/hello"])
    fun asd(): ScoreFunctionalDto {
        return ScoreFunctionalDto("entityId")
    }
}