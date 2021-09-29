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
        val scoreDto = ScoreDto("1")
        println(scoreDto)
    }
}