package ru.vood.generator.strict.meta

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ScoreDtoTest {

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun getF1() {
        val toList = IntRange(1, 20).map { ScoreDto("$it") }.toList()
        val scoreDto = ScoreDto("1")
        val scoreDto2 = ScoreDto("2")
        println(scoreDto)
        println(scoreDto2)
        println(toList)

    }
}