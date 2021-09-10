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
        return scoreFunctionalDto
    }

    @GetMapping(value = ["/scoreMap/{entityId}"])
    override fun readEntityByMap(entityId: String): Map<String, Any> {
        log.info("entityId => $entityId")
        val objectInMap = ScoreFunctionalDto(entityId).objectInMap
        return objectInMap
    }

    @GetMapping(value = ["/hello"])
    fun asd(): String {
        return ScoreFunctionalDto("5").id
    }
}