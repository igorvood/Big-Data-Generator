package ru.vood.generator.big.data.generator.data.gen

import org.springframework.stereotype.Service

@Service
class AbstractGenerateCollection : FunctionGenerateCollection {
    override fun <T> genOne(num: Int, gen: (Int) -> T): T {
        return gen.invoke(num)
    }
}