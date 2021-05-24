package ru.vood.generator.big.data.generator.first.gen

import org.apache.commons.lang3.RandomStringUtils
import org.springframework.stereotype.Service

@Service
class StringGenerator : GeneratorData<String> {
    override fun gen(): String {
        return RandomStringUtils.randomAlphanumeric(100)
    }
}