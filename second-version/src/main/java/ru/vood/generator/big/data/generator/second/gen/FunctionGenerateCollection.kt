package ru.vood.generator.big.data.generator.second.gen

import org.slf4j.LoggerFactory
import org.springframework.util.Assert
import java.util.stream.Collectors

interface FunctionGenerateCollection {

    companion object {
        val logger = LoggerFactory.getLogger(FunctionGenerateCollection::class.java)
    }

    fun <T> genOne(num: Int, gen: (Int) -> T): T

    fun <T> genList(min: Int = 0, max: Int, gen: (Int) -> T): List<T> {
        Assert.isTrue(min <= max) { " max($max) must be gather min($min) " }
        val cnt = (min until max).random()

        val intRange = IntRange(1, cnt).toList()
        return intRange.parallelStream()
                .peek { if (it % 10_500 == 0) logger.info("All ready Generate $it of ${gen.javaClass}") }
                .map { genOne(it, gen) }
                .collect(Collectors.toList())

    }

    fun <T> genSet(min: Int = 0, max: Int, gen: (Int) -> T): Set<T> = genList(min, max, gen).toSet()
}