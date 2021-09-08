package ru.vood.generator.forth.runner

import org.apache.commons.logging.LogFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.io.File
import java.time.Duration
import java.time.LocalDateTime

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
        val now: LocalDateTime = LocalDateTime.now()
        /*IntRange(1, cnt).toList().parallelStream()
            .forEach {
                val forObject =
                    restTemplate.getForObject("http://$host/score/$it", ScoreFunctionalDto::class.java)
                log.info(forObject)
            }*/

        IntRange(1, 8).toList().parallelStream()
            .forEach {thread ->
                File("${thread}_score.csv").bufferedWriter()
                    .use { out ->
                        IntRange(1, cnt)
                            .forEach {
                                if (it % 100 == 0) {
                                    val between1 = Duration.between(now, LocalDateTime.now())
                                    log.info("All ready put $it time ${between1.seconds / it.toDouble()} sec per score")
                                }
                                val score =
//                        restTemplate.getForObject("http://$host/score/$it", ScoreFunctionalDto::class.java)
//                        restTemplate.getForObject("http://$host/score/$it", String::class.java)
                                    restTemplate.getForObject("http://$host/scoreMap/$it", String::class.java)
                                out.write(score.toString() + "\n")
                            }
                    }
            }


        val between1 = Duration.between(now, LocalDateTime.now())
        log.info("total $cnt score, time ${between1.seconds} seconds: per score ${between1.seconds.toDouble() / cnt.toDouble()} sec")

    }
}