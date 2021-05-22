package ru.vood.generator.big.data.generator.data.gen.score

import org.springframework.stereotype.Service
import ru.vood.generator.big.data.generator.data.gen.FunctionGenerateCollection

@Service
class AbstractGenerateCollection : FunctionGenerateCollection {
    override fun <T> genOne(num: Int, gen: (Int) -> T): T {
        return gen.invoke(num)
    }
}