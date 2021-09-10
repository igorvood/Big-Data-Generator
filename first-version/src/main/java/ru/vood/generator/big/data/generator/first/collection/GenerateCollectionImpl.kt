package ru.vood.generator.big.data.generator.first.collection

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.util.Assert
import ru.vood.generator.big.data.generator.first.gen.GeneratorData
import java.util.stream.Collectors.toList


@Service
class GenerateCollectionImpl : GenerateCollection {
    val logger = LoggerFactory.getLogger(GenerateCollectionImpl::class.java)

    override fun <T> genList(min: Int, max: Int, gen: GeneratorData<T>): List<T> {
        Assert.isTrue(min <= max) { " max($max) must be gather min($min) " }
        val cnt = (min until max).random()

        val intRange = IntRange(1, cnt).toList()
        return intRange.parallelStream()
            .peek { if (it % 500 == 0) logger.info("All ready Generate $it of ${gen.javaClass}") }
            .map { gen.gen() }
            .collect(toList())
    }

}