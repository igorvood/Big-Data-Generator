package ru.vood.generator.forth.runner

import org.apache.commons.logging.LogFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ru.vood.generator.datamodel.score.ScoreFunctionalDto
import ru.vood.generator.forth.prop.GenerationProperties
import java.time.LocalDateTime
import java.util.*

@Service
class RunnerService(
    val restTemplateBuilder: RestTemplateBuilder
) : CommandLineRunner {

    @Value("\${gen.host}")
    lateinit var host: String

    @Value("\${gen.cnt}")
     var cnt: Int = 2

    private val log = LogFactory.getLog(RunnerService::class.java)

    private val restTemplate: RestTemplate by lazy { restTemplateBuilder.build() }

    override fun run(vararg args: String?) {
        val   now: LocalDateTime = LocalDateTime.now()
        IntRange(1, cnt).toList().parallelStream()
            .forEach {
                val forObject =
                    restTemplate.getForObject("http://$host/score/$it", ScoreFunctionalDto::class.java)
                log.info(forObject)
            }
        val sec : Long = (LocalDateTime.now().nano - now.nano).toLong()/1000
        log.info("per score ${sec/cnt.toLong()}")

    }
}